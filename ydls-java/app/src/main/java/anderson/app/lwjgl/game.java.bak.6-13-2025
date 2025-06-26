// src/main/java/com/example/Game.java
package anderson.app.lwjgl;






import java.net.URL;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.stb.STBImage.*;
import org.lwjgl.system.MemoryStack;

import java.util.*;


import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.io.File;



public class Game {
    private long window;
    private final int width = 800, height = 600;

    // Texture cache for digits
    private int[] digitTextures = null;

    // world & camera
    private final float worldWidth = width * 3f, worldHeight = height;
    private Camera camera;
    private Player player;
    private List<Platform> platforms;
    private List<Star> stars;
    private List<Mob> mobs;

    // UI
    private int lives = 3;
    private int score = 0;

    // controls mapping
    private Map<String, Integer> keyMap;
    private final String[] possibleKeys = {"Q","A","W","S","E","D"};

    public void run() {
        init();
        loop();
        cleanup();
    }

    private void init() {
        GLFWErrorCallback.createPrint(System.err).set();
        if (!GLFW.glfwInit()) throw new IllegalStateException("Unable to init GLFW");
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_FALSE);
        window = GLFW.glfwCreateWindow(width, height, "Platformer", 0, 0);
        GLFW.glfwMakeContextCurrent(window);
        GLFW.glfwShowWindow(window);
        GL.createCapabilities();
        glClearColor(0.5f, 0.8f, 1f, 0);

        // setup world
        camera = new Camera(width, height, worldWidth);
        randomizeControls();
        player = new Player(100, 50);
        generatePlatforms();
        spawnStars(5);
        mobs = new ArrayList<>();
    }

    private void randomizeControls() {
        List<Character> keys = new ArrayList<>(Arrays.asList('W','A','D','S','Q','E'));
        Collections.shuffle(keys);
        keyMap = new HashMap<>();
        keyMap.put("UP",    getKeyCode(keys.get(0)));
        keyMap.put("LEFT",  getKeyCode(keys.get(1)));
        keyMap.put("RIGHT", getKeyCode(keys.get(2)));
        keyMap.put("DOWN",  getKeyCode(keys.get(3)));
        System.out.println("Key Mapping:");
        System.out.println("UP    = " + keys.get(0));
        System.out.println("LEFT  = " + keys.get(1));
        System.out.println("RIGHT = " + keys.get(2));
        System.out.println("DOWN  = " + keys.get(3));
    }

    // Map character to GLFW key code
    private int getKeyCode(char c) {
        switch (c) {
            case 'Q': return GLFW.GLFW_KEY_Q;
            case 'A': return GLFW.GLFW_KEY_A;
            case 'W': return GLFW.GLFW_KEY_W;
            case 'S': return GLFW.GLFW_KEY_S;
            case 'E': return GLFW.GLFW_KEY_E;
            case 'D': return GLFW.GLFW_KEY_D;
            default:  return GLFW.GLFW_KEY_SPACE;
        }
    }

    private void generatePlatforms() {
        platforms = new ArrayList<>();
        // ground
        platforms.add(new Platform(0, 0, worldWidth, 20));
        // floating
        platforms.add(new Platform(400, 90, 200, 20));
        platforms.add(new Platform(800, 140, 150, 20));
        platforms.add(new Platform(1400,  290, 200, 20));
        platforms.add(new Platform(2000, 190, 200, 20));
    }

    private void spawnStars(int count) {
        stars = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < count; i++) {
            float x = 50 + rnd.nextFloat() * (worldWidth - 100);
            float y = 50 + rnd.nextFloat() * (worldHeight - 200);
            stars.add(new Star(x, y));
        }
    }

    private void loop() {
        double last = GLFW.glfwGetTime();
        while (!GLFW.glfwWindowShouldClose(window)) {
            double now = GLFW.glfwGetTime();
            float delta = (float)(now - last);
            last = now;

            update(delta);
            render();
            GLFW.glfwSwapBuffers(window);
            GLFW.glfwPollEvents();
        }
    }

    private void update(float dt) {
        
        // input
        if (GLFW.glfwGetKey(window, keyMap.get("LEFT")) == GLFW.GLFW_PRESS) player.moveHoriz(-1);
        if (GLFW.glfwGetKey(window, keyMap.get("RIGHT")) == GLFW.GLFW_PRESS) player.moveHoriz(1);
        
        if (GLFW.glfwGetKey(window, keyMap.get("UP")) == GLFW.GLFW_PRESS) player.jCharge();
        if (GLFW.glfwGetKey(window, keyMap.get("UP")) == GLFW.GLFW_RELEASE) player.jump();

        if (GLFW.glfwGetKey(window, keyMap.get("DOWN")) == GLFW.GLFW_PRESS) player.fall();
        

        player.applyGravity(dt);
        player.update(dt, platforms);
        camera.follow(player);

        // collect stars
        stars.removeIf(s -> {
            if (player.collides(s)) {
                score++;
                return true;
            }
            return false;
        });
        if (stars.isEmpty()) {
            spawnStars(5);
            randomizeControls();
        }

        // mobs update (simple spawning omitted)
        for (Mob m : mobs) m.update(dt);
        mobs.removeIf(m -> { if (player.collides(m)) { lives--; return true; } return false; });
    }

    private void render() {
        glClear(GL_COLOR_BUFFER_BIT);
        camera.begin();

        // draw platforms
        for (Platform p : platforms) p.render();
        // draw stars
        for (Star s : stars) s.render();
        // draw player
        player.render();
        // draw mobs
        for (Mob m : mobs) m.render();

        camera.end();

        // UI overlay
        renderUI();
    }

    private void renderUI() {
        // Simple UI: draw lives as red squares, score as quads count
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, width, 0, height, -1, 1);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();

        // Lives
        glColor3f(1,0,0);
        for (int i = 0; i < lives; i++) {
            glBegin(GL_QUADS);
            glVertex2f(10 + i*25, height - 10);
            glVertex2f(25 + i*25, height - 10);
            glVertex2f(25 + i*25, height - 25);
            glVertex2f(10 + i*25, height - 25);
            glEnd();
        }
        // Score indicator using digit textures
        if (digitTextures == null) {
            digitTextures = new int[10];
            for (int i = 0; i < 10; i++) {
                String path = "/anderson/number_" + i + ".png";
                digitTextures[i] = loadTexture(path);
            }
        }

        String scoreStr = Integer.toString(score);
        float sx = width / 2f - (scoreStr.length() * 20) / 2f;
        float sy = height - 30;
        float dx = 0;

        glEnable(GL_TEXTURE_2D);
        for (char c : scoreStr.toCharArray()) {
            int digit = c - '0';
            if (digit < 0 || digit > 9) continue;
            glBindTexture(GL_TEXTURE_2D, digitTextures[digit]);
            glColor3f(1, 1, 1);
            glBegin(GL_QUADS);
            glTexCoord2f(0, 0); glVertex2f(sx + dx, sy);
            glTexCoord2f(1, 0); glVertex2f(sx + dx + 20, sy);
            glTexCoord2f(1, 1); glVertex2f(sx + dx + 20, sy + 20);
            glTexCoord2f(0, 1); glVertex2f(sx + dx, sy + 20);
            glEnd();
            dx += 20;
        }
        glBindTexture(GL_TEXTURE_2D, 0);
        glDisable(GL_TEXTURE_2D);
        // glColor3f(1,1,0);
        // for (int i = 0; i < score; i++) {
        //     glBegin(GL_QUADS);
        //     glVertex2f(width/2 - 10 + i*15, height - 10);
        //     glVertex2f(width/2 + 10 + i*15, height - 10);
        //     glVertex2f(width/2 + 10 + i*15, height - 25);
        //     glVertex2f(width/2 - 10 + i*15, height - 25);
        //     glEnd();
        // }
        // Controls under player
        // Could draw small quads below player, omitted for brevity
    }



    // Texture loading utility
    private int loadTexture(String resourcePath) {
        int textureID;
        try (MemoryStack stack = MemoryStack.stackPush()) {
            IntBuffer width = stack.mallocInt(1);
            IntBuffer height = stack.mallocInt(1);
            IntBuffer channels = stack.mallocInt(1);

            // Load image from resource
            InputStream in = getClass().getResourceAsStream(resourcePath);
            if (in == null) throw new RuntimeException("Image not found: " + resourcePath);

            // Copy resource to a temp file
            File tempFile = File.createTempFile("texture", ".png");
            tempFile.deleteOnExit();
            Files.copy(in, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            // Flip image vertically on load
            stbi_set_flip_vertically_on_load(true);

            // Load image data
            ByteBuffer image = stbi_load(tempFile.getAbsolutePath(), width, height, channels, 4);
            if (image == null) throw new RuntimeException("Failed to load texture: " + stbi_failure_reason());

            // Generate OpenGL texture
            textureID = glGenTextures();
            glBindTexture(GL_TEXTURE_2D, textureID);
            glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width.get(), height.get(), 0, GL_RGBA, GL_UNSIGNED_BYTE, image);

            // Set texture parameters
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);

            stbi_image_free(image);
        } catch (Exception e) {
            throw new RuntimeException("Error loading texture: " + resourcePath, e);
        }

        return textureID;
    }

    private void cleanup() {
        GLFW.glfwDestroyWindow(window);
        GLFW.glfwTerminate();
        GLFW.glfwSetErrorCallback(null).free();
    }

    public static void main(String[] args) {
        new Game().run();
    }
}

// Camera follows the player
class Camera {
    private final int screenW, screenH;
    private final float worldW;
    private float x;
    public Camera(int w, int h, float worldW) { screenW=w; screenH=h; this.worldW=worldW; }
    public void follow(Player p) {
        x = p.x - screenW/2f;
        if (x<0) x=0;
        if (x>worldW-screenW) x=worldW-screenW;
    }
    public void begin() {
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(x, x+screenW, 0, screenH, -1, 1);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
    }
    public void end() { /* nothing */ }
}

// Simple player with gravity and collision
class Player {
    private final int width = 800, height = 600;
    private final float worldWidth = width * 3f, worldHeight = height;
    private final float speed = 200, jumpSpeed = 400, higherJumpAdditionalSpeed = 300, additionalJumpSpeed = 400;
    private final int MAX_ADDITIONAL_JUMP = 2;
    private final int MAX_COUNTER = 300;
    private final int _COUNTER_INCREMENT = 10;

    public float x, y;
    private float vx, vy;
    private boolean onGround;
    private int counter;
    private boolean enableAdditionalJump;
    private int numberOfJump;
    // For additional jump oval rendering
    private boolean showAdditionalJumpOval = false;
    private float jumpOvalTimer = 0f;
    private final float jumpOvalDuration = 0.3f;
    private float jumpOvalX = 0f, jumpOvalY = 0f;
    private float jumpOvalAlpha = 0f;

    public Player(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void moveHoriz(int dir) {
        vx = dir * speed;
    }

    public void jCharge() {
        enableAdditionalJump = (!onGround && numberOfJump < MAX_ADDITIONAL_JUMP);

        if (onGround && counter < MAX_COUNTER) {
            counter = counter + _COUNTER_INCREMENT;
        }
        if (counter >= higherJumpAdditionalSpeed) {
            
            counter = MAX_COUNTER;
        }
    }

    public void jump() {
        if (counter > _COUNTER_INCREMENT && onGround) {
            vy = jumpSpeed + counter;
            counter = 0;
        }
        if (enableAdditionalJump && !onGround) {
            vy = additionalJumpSpeed;
            this.enableAdditionalJump = false;
            numberOfJump++;

            // Show oval only when additional jump occurs
            showAdditionalJumpOval = true;
            jumpOvalTimer = jumpOvalDuration;
            jumpOvalX = x + 10;
            jumpOvalY = y - 5;
            jumpOvalAlpha = 0.5f;
        }
    }

    public void fall() {
            y = y - 20;
    }

    public void applyGravity(float dt) {
        vy -= 980 * dt;
    }

    public void update(float dt, List<Platform> plats) {
        x += vx * dt;
        y += vy * dt;
        onGround = false;

        if (x > worldWidth - 20) x = worldWidth - 20;
        if (x < 0) x = 0;
        if (y > worldHeight - 20) y = worldHeight - 20;
        if (y < 20) y = 20;
        for (Platform p : plats) {
            if (p.x - 20 < x && x < p.x + p.w 
                && 
                p.y + p.h - 5 < y && y < p.y + p.h + 5) { // on the platform
                if(vy < 0) { // only when falling (comming from top)
                    y = p.y + p.h;
                    onGround = true;
                    numberOfJump = 0;
                    vy = 0;
                }
            }
        }

        // Countdown timer for additional jump oval
                if (showAdditionalJumpOval) {
            jumpOvalTimer += dt;

            // Fade in for first 0.2s, then fade out for next 0.8s
            if (jumpOvalTimer <= 0.2f) {
                jumpOvalAlpha = jumpOvalTimer / 0.2f; // 0 to 1
            } else if (jumpOvalTimer <= 1.0f) {
                jumpOvalAlpha = 1f - (jumpOvalTimer - 0.2f) / 0.8f; // 1 to 0
            } else {
                showAdditionalJumpOval = false;
                jumpOvalAlpha = 0f;
                jumpOvalTimer = 0f;
            }
        }

        // System.out.println("Player{x=" + x + 
        // ", y=" + y + ", vx=" + vx + ", vy=" + vy + 
        // ", onGround=" + onGround + /* ",  isHigherJump=" + isHigherJump + */ 
        // ",  counter=" + counter + /* ",   additionalJumpinfo=" + additionalJumpinfo + */
        // ", numberOfJump=" + numberOfJump +
        // "}");

        if (y <= 20) {
            y = 20;
            onGround = true;
            vy = 0;
        }

        vx = 0;
    }

    public boolean collides(Star s) {
        return Math.hypot((x + 10) - s.x, (y + 10) - s.y) < 15;
    }

    public boolean collides(Mob m) {
        return x < m.x + m.size && x + 20 > m.x && y < m.y + m.size && y + 20 > m.y;
    }

    public void renderJumpOval() {
        if (!showAdditionalJumpOval || jumpOvalAlpha <= 0f) return;

        glPushMatrix();
        glTranslatef(jumpOvalX, jumpOvalY, 0);

        glColor4f(1f, 1f, 1f, jumpOvalAlpha); // fading opacity

        int segments = 40;
        float radiusX = 15f;
        float radiusY = 7f;

        glBegin(GL_TRIANGLE_FAN);
        glVertex2f(0, 0);
        for (int i = 0; i <= segments; i++) {
            double angle = 2 * Math.PI * i / segments;
            float dx = (float) Math.cos(angle) * radiusX;
            float dy = (float) Math.sin(angle) * radiusY;
            glVertex2f(dx, dy);
        }
        glEnd();

        glPopMatrix();
    }

    public void render() {
        renderJumpOval(); // draw oval if needed

        if (counter == 0) {
            glColor3f(0, 0, 1); // Blue when on ground
        } else {
            float red = Math.min(1.0f, counter / 300f); // Scale red based on charge
            glColor3f(red, 0, 1 - red); // Transition from blue to red
        }

        glBegin(GL_QUADS);
        glVertex2f(x, y);
        glVertex2f(x + 20, y);
        glVertex2f(x + 20, y + 20);
        glVertex2f(x, y + 20);
        glEnd();
    }
}



// Static platforms
class Platform {
    public float x, y, w, h;
    public Platform(float x, float y, float w, float h) { this.x=x; this.y=y; this.w=w; this.h=h; }
    public void render() {
        glColor3f(0.3f,0.3f,0.3f);
        glBegin(GL_QUADS);
        glVertex2f(x, y);
        glVertex2f(x+w, y);
        glVertex2f(x+w, y+h);
        glVertex2f(x, y+h);
        glEnd();
    }
}

// Collectible stars
class Star {
    public float x, y;
    public Star(float x, float y) { this.x=x; this.y=y; }
    public void render() {
        glColor3f(1,1,0);
        glBegin(GL_TRIANGLES);
        glVertex2f(x, y);
        glVertex2f(x+10, y);
        glVertex2f(x+5, y+15);
        glEnd();
    }
}

// Simple mob stub
class Mob {
    public float x, y; public float size=20;
    public Mob(float x, float y) { this.x=x; this.y=y; }
    public void update(float dt) { /* random or patterned movement */ }
    public void render() {
        glColor3f(1,0,1);
        glBegin(GL_QUADS);
        glVertex2f(x, y);
        glVertex2f(x+size, y);
        glVertex2f(x+size, y+size);
        glVertex2f(x, y+size);
        glEnd();
    }
}