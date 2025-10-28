package Medium;

public class UniqueBST {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i / 2; j++) {
                dp[i] += (dp[j - 1] * dp[i - j] * 2);
            }
            if(i % 2 == 1) {
                dp[i] += (dp[i / 2] * dp[i / 2]);
            }
        }
        return dp[n];
    }
}