public class Matrix {
    // Fields
    private int[][] values;
    // Constructor
    public Matrix(int[][] bareMatrix) {
        this.values = new int[bareMatrix.length][bareMatrix[0].length];
        for (int row = 0; row < this.values.length; row++) {
            for (int col = 0; col < this.values[i].length; col++) {
                this.values[row][col] = bareMatrix[row][col];
            }
        }
    }


    // System-Builtin Methods (Inheritance)
    @Override
    public String toString() {
        return super.toString();
    }
}