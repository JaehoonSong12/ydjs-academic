package jayden.app;

public class TicTacToeModel {
    private String[][] board;
    private String currentPlayer;

    public static final String PLAYER_X = "X";
    public static final String PLAYER_O = "O";

    public TicTacToeModel() {
        board = new String[3][3];
        currentPlayer = PLAYER_X;
    }

    public boolean makeMove(int r, int c) {
        if (board[r][c] == null) {
            board[r][c] = currentPlayer;
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != null && board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]))
                return true;
            if (board[0][i] != null && board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i]))
                return true;
        }
        // Check diagonals
        if (board[0][0] != null && board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]))
            return true;
        if (board[0][2] != null && board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]))
            return true;
        return false;
    }

    public boolean isBoardFull() {
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                if (board[r][c] == null)
                    return false;
        return true;
    }

    public void switchPlayer() {
        currentPlayer = currentPlayer.equals(PLAYER_X) ? PLAYER_O : PLAYER_X;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }
    
    public boolean isOccupied(int r, int c) {
        return board[r][c] != null;
    }
}
