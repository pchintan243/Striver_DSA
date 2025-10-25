package Medium.2D;
// Tabulation Form
public class NinjaTraining {
    public int ninjaTraining(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][3];

        dp[0][0] = matrix[0][0];
        dp[0][1] = matrix[0][1];
        dp[0][2] = matrix[0][2];
        for(int i = 1; i < n; i++) {
            int temp = Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][0] = temp + matrix[i][0];

            temp = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = temp + matrix[i][1];

            temp = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][2] = temp + matrix[i][2];
        }
        return Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
    }
}

// Space Optimization
class NinjaTraining {
    public int ninjaTraining(int[][] matrix) {
        int n = matrix.length;

        int first = matrix[0][0];
        int sec = matrix[0][1];
        int third = matrix[0][2];
        for(int i = 1; i < n; i++) {
            int temp = Math.max(sec, third);
            int tempFirst = temp + matrix[i][0];

            temp = Math.max(first, third);
            int tempSec = temp + matrix[i][1];

            temp = Math.max(first, sec);
            int tempThird = temp + matrix[i][2];

            first = tempFirst;
            sec = tempSec;
            third = tempThird;
        }
        return Math.max(first, Math.max(sec, third));
    }
}