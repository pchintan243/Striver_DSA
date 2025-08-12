package Daily_Problem.2025.08;

class 12_2787_SumOfPower_Optimal {
    private final int MOD = (int) 1e9 + 7;

    public int numberOfWays(int n, int x) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; Math.pow(i, x) <= n; i++) {
            int pow = ((int) Math.pow(i, x)) % MOD;

            for(int sum = n; sum >= pow; sum--) {
                dp[sum] = (dp[sum] + dp[sum - pow]) % MOD;
            }
        }
        return dp[n];
    }
}