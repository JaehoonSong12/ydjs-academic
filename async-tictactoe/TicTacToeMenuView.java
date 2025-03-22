package jayden.app;

import javax.swing.*;
import java.awt.*;

public class TicTacToeMenuView extends JPanel {
    public TicTacToeMenuView(MainFrame frame) {
        setLayout(new GridLayout(4, 1, 10, 10));
        setBackground(Color.DARK_GRAY);

        JLabel title = new JLabel("Tic-Tac-Toe", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setForeground(Color.WHITE);

        JButton easyBtn = new JButton("Easy AI");
        JButton mediumBtn = new JButton("Medium AI");
        JButton hardBtn = new JButton("Hard AI");

        styleButton(easyBtn);
        styleButton(mediumBtn);
        styleButton(hardBtn);

        easyBtn.addActionListener(e -> frame.startGame("Easy"));
        mediumBtn.addActionListener(e -> frame.startGame("Medium"));
        hardBtn.addActionListener(e -> frame.startGame("Hard"));

        add(title);
        add(easyBtn);
        add(mediumBtn);
        add(hardBtn);
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 24));
        button.setBackground(Color.LIGHT_GRAY);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
    }
}
