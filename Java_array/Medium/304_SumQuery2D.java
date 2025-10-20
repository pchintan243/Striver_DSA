package Medium;

public class 304_SumQuery2D {
    int[][] mat;
    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        mat = new int[n][m];
        for(int i = 0; i < n; i++) {
            mat[i][0] = matrix[i][0];
            for(int j = 1; j < m; j++) {
                mat[i][j] = matrix[i][j] + mat[i][j - 1];
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 1; j < n; j++) {
                mat[j][i] += mat[j - 1][i];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = mat[row2][col2];

        if(row1 > 0) {
            ans -= mat[row1 - 1][col2];
        }
        if(col1 > 0) {
            ans -= mat[row2][col1 - 1];
        }
        if(row1 > 0 && col1 > 0) {
            ans += mat[row1 - 1][col1 - 1];
        }
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
