package jayden.app;

import javax.swing.*;

public class TicTacToeController {
    private TicTacToeModel model;
    private TicTacToeView view;
    private MainFrame frame;
    private AIPlayer ai;

    public TicTacToeController(TicTacToeModel model, TicTacToeView view, MainFrame frame, AIPlayer ai) {
        this.model = model;
        this.view = view;
        this.frame = frame;
        this.ai = ai;

        // Set up listeners on each board tile.
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                final int row = r, col = c;
                view.getTile(r, c).addActionListener(e -> handleMove(row, col));
            }
        }
    }

    private void handleMove(int r, int c) {
        // Human move (assume human is always "X")
        if (!model.isOccupied(r, c) && model.getCurrentPlayer().equals(TicTacToeModel.PLAYER_X)) {
            if (model.makeMove(r, c)) {
                view.updateBoard(r, c, TicTacToeModel.PLAYER_X);
                if (model.checkWin()) {
                    view.setStatus("You win!");
                    view.showMessage("Congratulations! You win!");
                    frame.showGameOver("You Win!");
                    return;
                }
                if (model.isBoardFull()) {
                    view.setStatus("It's a tie!");
                    view.showMessage("It's a tie!");
                    frame.showGameOver("It's a Tie!");
                    return;
                }
                model.switchPlayer();
                view.setStatus("AI's Turn");
                doAIMove();
            }
        }
    }

    private void doAIMove() {
        SwingUtilities.invokeLater(() -> {
            int[] move = ai.getMove(model);
            if (move != null && !model.isOccupied(move[0], move[1])) {
                model.makeMove(move[0], move[1]);
                view.updateBoard(move[0], move[1], TicTacToeModel.PLAYER_O);
                if (model.checkWin()) {
                    view.setStatus("AI wins!");
                    view.showMessage("You lose!");
                    frame.showGameOver("You Lose!");
                    return;
                }
                if (model.isBoardFull()) {
                    view.setStatus("It's a tie!");
                    view.showMessage("It's a tie!");
                    frame.showGameOver("It's a Tie!");
                    return;
                }
                model.switchPlayer();
                view.setStatus("Your Turn");
            }
        });
    }
}
