package Grids;

public class MinPathFallingSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] prev = new int[m];
        for(int i = 0; i < m; i++) {
            prev[i] = matrix[0][i];
        }

        for(int i = 1; i < n; i++) {
            int[] curr = new int[m];
            for(int j = 0; j < m; j++) {
                int b = prev[j];
                int br = j < m - 1 ? prev[j + 1] : Integer.MAX_VALUE;
                int bl = j > 0 ? prev[j - 1] : Integer.MAX_VALUE;

                curr[j] = matrix[i][j] + Math.min(b, Math.min(br, bl));
            }

            prev = curr;
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            ans = Math.min(ans, prev[i]);
        }
        return ans;
    }
}
