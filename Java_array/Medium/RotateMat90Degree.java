package Medium;

public class RotateMat90Degree {
    public void rotateMatrix(int[][] matrix) {
        int n = matrix.length;

        int len = n / 2;
        for(int i = 0; i < len; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[n - i - 1];
            matrix[n - i - 1] = temp;
        }
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                swap(matrix, i, j);
            }
        }
    }
    void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}