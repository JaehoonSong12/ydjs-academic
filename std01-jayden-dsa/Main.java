/**
 * The MatrixOperations class provides static methods for common
 * matrix manipulations and arithmetic operations, including:
 * <ul>
 *   <li>Addition</li>
 *   <li>Subtraction</li>
 *   <li>Multiplication</li>
 *   <li>Transpose</li>
 *   <li>Determinant (recursive)</li>
 *   <li>Inverse (via adjugate)</li>
 * </ul>
 *
 * How to compile and run the application:
 * 1. Open a terminal or command prompt.
 * 2. Compile: 
 *      ```
 *      javac std01-jayden-dsa/Main.java
 *      ```
 * 3. Run & Clean: 
 *      ```
 *      java -cp std01-jayden-dsa Main; rm -rf std01-jayden-dsa/*.class
 *      ```
 */
class Matrix {
    // Fields
    private double[][] values;
    // Constructor
    public Matrix(double[][] bareMatrix) {
        this.values = new double[bareMatrix.length][bareMatrix[0].length];
        for (int row = 0; row < this.values.length; row++) {
            for (int col = 0; col < this.values[row].length; col++) {
                this.values[row][col] = bareMatrix[row][col];
            }
        }
    }
    public double getValue(int row, int col) {
        return this.values[row][col];
    }
    public int rowSize() {
        return this.values.length;
    }
    public int colSize() {
        return this.values[0].length;
    }




    /**
     * Adds two matrices of the same dimensions.
     *
     * @param additionOperand matrix to add
     * @return the result of this + additionOperand
     * @throws IllegalArgumentException if dimensions do not match
     */
    public Matrix add(Matrix additionOperand) {
        int rows = this.values.length;
        int cols = this.values[0].length;
        if (rows != additionOperand.rowSize() || cols != additionOperand.colSize()) throw new IllegalArgumentException("Matrices must have the same dimensions.");
        double[][] result = new double[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                result[row][col] = this.getValue(row,col) + additionOperand.getValue(row,col);
            }
        }
        return new Matrix(result);
    }


    /**
     * Multiplies two matrices where A.cols == B.rows.
     *
     * @param multiOperand left matrix
     * @return the result of A * B
     * @throws IllegalArgumentException if inner dimensions do not match
     */    
    public Matrix multiply(Matrix multiOperand) {
        int r1 = this.values.length;
        int c1 = this.values[0].length;
        int r2 = multiOperand.rowSize();
        int c2 = multiOperand.colSize();
        if (c1 != r2) throw new IllegalArgumentException("A's columns must match B's rows.");
        
        double[][] result = new double[r1][c2];
        for (int row = 0; row < r1; row++) {
            for (int col = 0; col < c2; col++) {
                for (int index = 0; index < c1; index++) {
                    result[row][col] += this.values[row][index] * multiOperand.values[index][col];
                }
            }
        }
        return new Matrix(result);
    }




    // System-Builtin Methods (Inheritance)
    @Override
    public String toString() {
        // Unicode box-drawing characters for pretty matrix output
        final char TOP_LEFT = '\u250C';      // left-top
        final char TOP_RIGHT = '\u2510';     // right-top
        final char BOTTOM_LEFT = '\u2514';   // left-bottom
        final char BOTTOM_RIGHT = '\u2518';  // right-bottom
        final char VERTICAL = '\u2502';      // side
        String result = "";
        result += "";
        // empty matrix
        if (this.values.length == 0) {
            return "[ ]";
        }
        // top border
        result += TOP_LEFT;
        for (int col = 0; col < this.values[0].length; col++) {
            String element = String.format("%8c%2c", ' ', ' ');
            result += element;
        }
        result += TOP_RIGHT + "\n";
        // row x col, elements
        for (int row = 0; row < this.values.length; row++) {
            result += VERTICAL;
            for (int col = 0; col < this.values[row].length; col++) {
                String element = String.format("%8.2f%2c", this.values[row][col], ' ');
                result += element;
            }
            result += VERTICAL + "\n";
        }
        // bottom border
        result += BOTTOM_LEFT;
        for (int col = 0; col < this.values[0].length; col++) {
            String element = String.format("%8c%2c", ' ',' ');
            result += element;
        }
        result += BOTTOM_RIGHT + "\n";

        return result;
    }
}

public class Main {
    

    /**
     * Example main for demonstration.
     */
    public static void main(String[] args) {
        double[][] A = new double[][] { 
            {1, 2}, 
            {3, 4} 
        };
        
        double[][] B = new double[][] { 
            {5, 6}, 
            {7, 8} 
        };


        Matrix matrixA = new Matrix(A);
        Matrix matrixB = new Matrix(B);
        System.out.println(matrixA);
        System.out.println("+");
        System.out.println(matrixB);
        System.out.println("=");
        System.out.println(matrixA.add(matrixB));



        matrixA = new Matrix(new double[][] { 
            {1, 2, 3}, 
            {2, 1, 3} 
        });
        matrixB = new Matrix(new double[][] { 
            {1,2,3,1}, 
            {4,1,3,1},
            {1,2,3,1}
        });
        System.out.println(matrixA);
        System.out.println("x");
        System.out.println(matrixB);
        System.out.println("=");
        System.out.println(matrixA.multiply(matrixB));





        A = new double[][] {  
            {1, 2}, 
            {3, 4} 
        };
        System.out.println("A[1][1] = " + A[1][1]);
        
        System.out.println("A + B = ");
        print(add(A, B));
        System.out.println("A * B = ");
        print(multiply(A, B));
        System.out.println("det(A) = " + determinant(A));
        System.out.println("transpose(A) = ");
        print(transpose(A));
    }

    /**
     * Utility to print a matrix to stdout.
     */
    private static void print(double[][] M) {
        for (double[] row : M) {
            for (double val : row) {
                System.out.printf("%2.2f", val);
            }
            System.out.println();
        }
    }

















    /**
     * Adds two matrices of the same dimensions.
     *
     * @param A first matrix
     * @param B second matrix
     * @return the result of A + B
     * @throws IllegalArgumentException if dimensions do not match
     */
    public static double[][] add(double[][] A, double[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        if (rows != B.length || cols != B[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions.");
        }
        double[][] C = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    /**
     * Multiplies two matrices where A.cols == B.rows.
     *
     * @param A left matrix
     * @param B right matrix
     * @return the result of A * B
     * @throws IllegalArgumentException if inner dimensions do not match
     */
    public static double[][] multiply(double[][] A, double[][] B) {
        int r1 = A.length;
        int c1 = A[0].length;
        int r2 = B.length;
        int c2 = B[0].length;
        if (c1 != r2) {
            throw new IllegalArgumentException("A's columns must match B's rows.");
        }
        double[][] C = new double[r1][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    /**
     * Transposes the given matrix.
     *
     * @param A the matrix to transpose
     * @return the transpose of A
     */
    public static double[][] transpose(double[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        double[][] T = new double[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                T[j][i] = A[i][j];
            }
        }
        return T;
    }

    /**
     * Computes the determinant of a square matrix recursively.
     *
     * @param A square matrix
     * @return determinant of A
     * @throws IllegalArgumentException if A is not square
     */
    public static double determinant(double[][] A) {
        int n = A.length;
        if (n != A[0].length) {
            throw new IllegalArgumentException("Matrix must be square.");
        }
        if (n == 1) {
            return A[0][0];
        }
        if (n == 2) {
            return A[0][0] * A[1][1] - A[0][1] * A[1][0];
        }
        double det = 0;
        for (int col = 0; col < n; col++) {
            det += Math.pow(-1, col) * A[0][col] *
                   determinant(minor(A, 0, col));
        }
        return det;
    }

    /**
     * Helper to compute minor matrix by removing specified row and column.
     */
    private static double[][] minor(double[][] A, int row, int col) {
        int n = A.length;
        double[][] M = new double[n - 1][n - 1];
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (i == row) continue;
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (j == col) continue;
                M[r][c++] = A[i][j];
            }
            r++;
        }
        return M;
    }

    public static double[][] inverse(double[][] A) {
        double det = determinant(A);
        if (det == 0) {
            throw new IllegalArgumentException("Matrix is singular and cannot be inverted.");
        }
        int n = A.length;
        double[][] adjugate = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjugate[j][i] = Math.pow(-1, i + j) * determinant(minor(A, i, j));
            }
        }
        // Multiply adjugate by scalar 1/det to get the inverse
        return scalarMultiply(adjugate, 1 / det);
    }

    /**
     * Multiplies every element of the matrix by a scalar.
     *
     * @param A matrix
     * @param scalar value to multiply
     * @return new matrix with each element multiplied by scalar
     */
    public static double[][] scalarMultiply(double[][] A, double scalar) {
        int rows = A.length;
        int cols = A[0].length;
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] * scalar;
            }
        }
        return result;
    }
}
