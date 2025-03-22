package jayden.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AIPlayer {
    private String difficulty;
    private Random random = new Random();

    public AIPlayer(String difficulty) {
        this.difficulty = difficulty;
    }

    // For simplicity, all difficulties select a random available move.
    // (You can expand this to add smarter logic for "Medium" or "Hard".)
    public int[] getMove(TicTacToeModel model) {
        List<int[]> moves = new ArrayList<>();
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (!model.isOccupied(r, c)) {
                    moves.add(new int[]{r, c});
                }
            }
        }
        if (moves.isEmpty()) return null;
        return moves.get(random.nextInt(moves.size()));
    }
}
