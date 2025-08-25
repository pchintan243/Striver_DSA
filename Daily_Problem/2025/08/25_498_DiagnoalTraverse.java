package Daily_Problem.2025.08;

public class 25_498_DiagnoalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] ans = new int[n * m];
        int ind = 0;
        int row = 0;
        int col = 0;
        boolean up = true;
        while(ind < (m * n)) {
            ans[ind++] = mat[row][col];

            if(up) {
                if(col == m - 1) {
                    row++;
                    up = false;
                } else if(row == 0) {
                    col++;
                    up = false;
                } else {
                    row--;
                    col++;
                }
            } else {
                if(row == n - 1) {
                    col++;
                    up = true;
                } else if(col == 0) {
                    row++;
                    up = true;
                } else {
                    row++;
                    col--;
                }
            }
        }
        return ans;
    }
}