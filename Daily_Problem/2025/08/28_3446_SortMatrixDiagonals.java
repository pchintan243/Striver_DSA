package Daily_Problem.2025.08;
import java.util.Arrays;

class 28_3446_SortMatrixDiagonals {
    public int[][] sortMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        for (int row = 0; row < rows; row++) {
            sortDiagonal(mat, row, 0, false); // false for non-increasing
        }

        for (int col = 1; col < cols; col++) {
            sortDiagonal(mat, 0, col, true); // true for non-decreasing
        }

        return mat;
    }

    private void sortDiagonal(int[][] mat, int row, int col, boolean increasing) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        int len = Math.min(rows - row, cols - col);
        int[] diagonal = new int[len];

        for (int i = 0; i < len; i++) {
            diagonal[i] = mat[row + i][col + i];
        }

        Arrays.sort(diagonal);
        if(increasing) {
            for (int i = 0; i < len; i++) {
                mat[row + i][col + i] = diagonal[i];
            }
        } else {
            for (int i = len - 1, ind = 0; i >= 0; i--) {
                mat[row + i][col + i] = diagonal[ind++];
            }
        }
    }
}