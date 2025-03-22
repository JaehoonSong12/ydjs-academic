package jayden.app;

import javax.swing.*;
import java.awt.*;

public class TicTacToeGameOverView extends JPanel {
    private JLabel messageLabel;
    private JButton restartButton;
    private JButton menuButton;
    private MainFrame frame;

    public TicTacToeGameOverView(MainFrame frame) {
        this.frame = frame;
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.BLACK);

        messageLabel = new JLabel("", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 50));
        messageLabel.setForeground(Color.RED);
        add(messageLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        buttonPanel.setBackground(Color.BLACK);

        restartButton = new JButton("Restart");
        menuButton = new JButton("Main Menu");

        styleButton(restartButton);
        styleButton(menuButton);

        // Restart with a default difficulty (e.g. "Medium")
        restartButton.addActionListener(e -> frame.startGame("Medium"));
        menuButton.addActionListener(e -> frame.showMenu());

        buttonPanel.add(restartButton);
        buttonPanel.add(menuButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 25));
        button.setBackground(Color.DARK_GRAY);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.RED, 2));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.RED);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.DARK_GRAY);
            }
        });
    }

    public void setMessage(String message) {
        messageLabel.setText(message);
        animateLossEffect();
    }


    private static int blinkingCount = 4;
    private static int blinkingSpeed = 500; // in milli-second

    private void animateLossEffect() {
        new Thread(() -> {
            try {
                for (int i = 0; i < blinkingCount; i++) {
                    messageLabel.setForeground(Color.BLACK);
                    Thread.sleep(blinkingSpeed);
                    messageLabel.setForeground(Color.RED);
                    Thread.sleep(blinkingSpeed);
                }
            } catch (InterruptedException ignored) {
            }
        }).start();
    }
}
