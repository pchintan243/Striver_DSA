package Grids;

public class UniquePath-II {
    public int uniquePathsWithObstacles(int[][] matrix) {
        if(matrix[0][0] == 1) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;

        int[] prev = new int[m];
        for(int i = 0; i < m; i++) {
            if(matrix[0][i] == 0)
                prev[i] = 1;
            else 
                break;
        }

        for(int i = 1; i < n; i++) {
            int[] curr = new int[m];
            curr[0] = 1;
            if(prev[0] == 0 || matrix[i][0] == 1) {
                curr[0] = 0;
            }
            for(int j = 1; j < m; j++) {
                if(matrix[i][j] == 1) {
                    continue;
                }
                curr[j] = curr[j - 1] + prev[j];
            }
            prev = curr;
        }
        return prev[m - 1];
    }
}