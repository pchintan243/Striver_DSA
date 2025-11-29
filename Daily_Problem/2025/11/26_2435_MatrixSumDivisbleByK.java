package Daily_Problem.2025.11;
import java.util.Arrays;

public class 26_2435_MatrixSumDivisbleByK {
    public int numberOfPaths(int[][] grid, int k) {
        int MOD = 1000000007;
        int n = grid.length;
        int m = grid[0].length;
        int[] ans = new int[1];
        int[][] dp = new int[m][k];
        dp[0][grid[0][0] % k] = 1;
        int[] currentCell = new int[k];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 && j = 0) {
                    continue;
                }
                Arrays.fill(currentCell, 0);
                int val = grid[i][j];
            }
        }
        return recursion(grid, k, 0, 0, n, m, 0, dp);
    }
}