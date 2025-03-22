package jayden.app;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private TicTacToeMenuView menuView;
    private TicTacToeView gameView;
    private TicTacToeGameOverView gameOverView;
    private TicTacToeController controller;

    public MainFrame() {
        setTitle("Tic-Tac-Toe");
        setSize(600, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        menuView = new TicTacToeMenuView(this);
        gameOverView = new TicTacToeGameOverView(this);

        mainPanel.add(menuView, "menu");
        mainPanel.add(gameOverView, "gameOver");

        add(mainPanel);
        setVisible(true);

        showMenu();
    }

    // Start a new game with the selected difficulty ("Easy", "Medium", or "Hard")
    public void startGame(String difficulty) {
        TicTacToeModel model = new TicTacToeModel();
        AIPlayer ai = new AIPlayer(difficulty);
        gameView = new TicTacToeView();
        controller = new TicTacToeController(model, gameView, this, ai);
        mainPanel.add(gameView, "game");
        cardLayout.show(mainPanel, "game");
    }

    public void showMenu() {
        cardLayout.show(mainPanel, "menu");
    }

    // Show the game over screen with a custom message
    public void showGameOver(String message) {
        gameOverView.setMessage(message);
        cardLayout.show(mainPanel, "gameOver");
    }
}
