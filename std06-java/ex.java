import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Demonstrates a basic hover effect using MouseAdapter.
 * In Swing, you must manually toggle the state on entry and exit.
 */
public class HoverExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing Hover Effect");
        JButton button = new JButton("Hover Over Me");

        // Set initial state
        button.setBackground(Color.LIGHT_GRAY);
        button.setFocusPainted(false); // Clean up the UI

        // Add the hover logic
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Change style when mouse enters the component area
                button.setBackground(Color.CYAN);
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Revert style when mouse leaves
                button.setBackground(Color.LIGHT_GRAY);
                button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        frame.setLayout(new FlowLayout());
        frame.add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}