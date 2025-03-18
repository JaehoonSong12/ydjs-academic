package jayden.app;

import javax.swing.*;
import java.awt.*;

public class TicTacToeView extends JPanel {
    private JLabel statusLabel;
    private JButton[][] board = new JButton[3][3];

    public TicTacToeView() {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        statusLabel = new JLabel("Your Turn", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 28));
        statusLabel.setForeground(Color.CYAN);
        add(statusLabel, BorderLayout.NORTH);

        JPanel boardPanel = new JPanel(new GridLayout(3, 3, 5, 5));
        boardPanel.setBackground(Color.BLACK);
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = new JButton();
                styleButton(board[r][c]);
                boardPanel.add(board[r][c]);
            }
        }
        add(boardPanel, BorderLayout.CENTER);
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 80));
        button.setBackground(new Color(30, 30, 30));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.CYAN, 3));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(50, 50, 50));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(30, 30, 30));
            }
        });
    }

    public JButton getTile(int r, int c) {
        return board[r][c];
    }

    public void updateBoard(int r, int c, String text) {
        board[r][c].setText(text);
    }

    public void setStatus(String text) {
        statusLabel.setText(text);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
