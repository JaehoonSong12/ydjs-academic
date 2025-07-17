package anderson.app.lwjgl;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import java.nio.ByteBuffer;
import java.util.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

public class OrbitronDemo {
    private long window;
    private final int worldWidth = 1024, worldHeight = 768;

    // Input buffer for typing
    private StringBuilder inputBuffer = new StringBuilder();
    // Recent messages queue
    private final Deque<Message> messages = new ArrayDeque<>();
    private static final double DISPLAY_DURATION = 5.0;
    private static final int MAX_MESSAGES = 3;

    public void run() {
        initWindow();
        loop();
        glfwTerminate();
    }

    private void initWindow() {
        GLFWErrorCallback.createPrint(System.err).set();
        if (!glfwInit()) throw new IllegalStateException("Unable to initialize GLFW");

        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);
        window = glfwCreateWindow(worldWidth, worldHeight, "Orbitron LWJGL Demo", NULL, NULL);
        if (window == NULL) throw new RuntimeException("Failed to create GLFW window");

        glfwMakeContextCurrent(window);
        GL.createCapabilities();

        // Enable blending for transparency
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

        // Set pale sky blue background
        glClearColor(0.5f, 0.8f, 1.0f, 1.0f);



        // Key input callback
        glfwSetKeyCallback(window, (win, key, scancode, action, mods) -> {
            if (action == GLFW_PRESS) {
                String text = "";
                switch (key) {
                    case GLFW_KEY_Q: 
                        text = "You pressed Q!";
                        addMessage(text);
                        break;
                    case GLFW_KEY_W: 
                        text = "You pressed W!";
                        addMessage(text);
                        break;
                    case GLFW_KEY_E: 
                        text = "You pressed E!";
                        addMessage(text);
                        break;
                    case GLFW_KEY_A: 
                        text = "You pressed A!";
                        addMessage(text);
                        break;
                    case GLFW_KEY_S: 
                        text = "You pressed S!";
                        addMessage(text);
                        break;
                    case GLFW_KEY_D: 
                        text = "You pressed D!";
                        addMessage(text);
                        break;
                    case GLFW_KEY_ENTER:
                        text = "You are now in the shop!";
                        addMessage(text);
                        break;
                    default: break;
                }
            }
        });

        glViewport(0, 0, worldWidth, worldHeight);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, worldWidth, worldHeight, 0, -1, 1);
        glMatrixMode(GL_MODELVIEW);
    }

    private void addMessage(String text) {
        double now = glfwGetTime();
        text = "You just pressed: " + text.trim();
        if (messages.size() >= MAX_MESSAGES) {
            Message oldest = messages.removeFirst();
            glDeleteTextures(oldest.texId);
        }
        messages.addLast(new Message(text, now));
    }

    private void loop() {
        while (!glfwWindowShouldClose(window)) {
            double now = glfwGetTime();
            glClear(GL_COLOR_BUFFER_BIT);

            // Expire old messages
            Iterator<Message> it = messages.iterator();
            while (it.hasNext()) {
                Message m = it.next();
                if (now - m.timestamp > DISPLAY_DURATION) {
                    glDeleteTextures(m.texId);
                    it.remove();
                }
            }

            // Draw queued messages
            int idx = 0;
            for (Message m : messages) {
                double age = now - m.timestamp;
                float alpha = (float) Math.max(0.0, 1.0 - (age / DISPLAY_DURATION));
                drawMessage(m.texId, m.worldWidth, m.worldHeight, idx, alpha);
                idx++;
            }

            glfwSwapBuffers(window);
            glfwPollEvents();
        }
    }

    private void drawMessage(int texId, int textW, int textH, int index, float alpha) {
        int boxW = textW + 20;
        int boxH = textH + 20;
        int x = (worldWidth - boxW) / 2;
        int y = 50 + index * (boxH + 10);

        // Black background box with fade
        glDisable(GL_TEXTURE_2D);
        glColor4f(0f, 0f, 0f, 0.75f * alpha);
        glBegin(GL_QUADS);
            glVertex2f(x,     y);
            glVertex2f(x+boxW, y);
            glVertex2f(x+boxW, y+boxH);
            glVertex2f(x,     y+boxH);
        glEnd();

        // Text quad with fade
        glEnable(GL_TEXTURE_2D);
        glBindTexture(GL_TEXTURE_2D, texId);
        glColor4f(1f, 1f, 1f, alpha);
        glBegin(GL_QUADS);
            glTexCoord2f(0,0); glVertex2f(x+10,     y+10);
            glTexCoord2f(1,0); glVertex2f(x+10+textW, y+10);
            glTexCoord2f(1,1); glVertex2f(x+10+textW, y+10+textH);
            glTexCoord2f(0,1); glVertex2f(x+10,     y+10+textH);
        glEnd();

        // Reset color
        glColor4f(1f,1f,1f,1f);
    }

    private class Message {
        final int texId;
        final int worldWidth, worldHeight;
        final double timestamp;

        Message(String text, double timestamp) {
            this.timestamp = timestamp;
            int[] dims = createOrbitronTexture(text, 10);
            this.worldWidth = dims[0];
            this.worldHeight = dims[1];
            this.texId = currentTex;
        }
    }

    private int currentTex;

    private int[] createOrbitronTexture(String text, int padding) {
        Font font = new Font("Orbitron", Font.PLAIN, (int) (worldWidth / 42.0));
        // create an AffineTransform that only scales Y
        AffineTransform at = AffineTransform.getScaleInstance(1.0, 1.8); 
        Font tallFont = font.deriveFont(at);

        BufferedImage tmp = new BufferedImage(1,1,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = tmp.createGraphics();
        g2d.setFont(tallFont); // for box
        FontMetrics fm = g2d.getFontMetrics();
        int textW = fm.stringWidth(text);
        int textH = fm.getHeight();
        g2d.dispose();

        int imgW = textW + padding * 2;
        int imgH = textH + padding * 2;
        BufferedImage img = new BufferedImage(imgW, imgH, BufferedImage.TYPE_INT_ARGB);
        g2d = img.createGraphics();
        g2d.setFont(tallFont); // for actual text
        g2d.setColor(Color.WHITE);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.drawString(text, padding, fm.getAscent() + padding);
        g2d.dispose();

        int texId = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, texId);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);

        int[] pixels = img.getRGB(0,0,imgW,imgH,null,0,imgW);
        ByteBuffer buffer = BufferUtils.createByteBuffer(imgW * imgH * 4);
        for (int y = 0; y < imgH; y++) {
            for (int x = 0; x < imgW; x++) {
                int p = pixels[y * imgW + x];
                buffer.put((byte)((p >> 16) & 0xFF));
                buffer.put((byte)((p >> 8) & 0xFF));
                buffer.put((byte)(p & 0xFF));
                buffer.put((byte)((p >> 24) & 0xFF));
            }
        }
        buffer.flip();
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, imgW, imgH, 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);
        currentTex = texId;
        return new int[]{textW, textH};
    }

    public static void main(String[] args) {
        new OrbitronDemo().run();
    }
}
