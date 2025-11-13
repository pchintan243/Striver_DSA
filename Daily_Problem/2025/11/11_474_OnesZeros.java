package Daily_Problem.2025.11;

class 11_474_OnesZeros {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for(String str: strs) {
            int zeroes = 0;
            int ones = 0;
            for(char c: str.toCharArray()) {
                if(c == '0') zeroes++;
                else ones++;
            }
            for(int i = m; i >= zeroes; i--) {
                for(int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroes][j - ones] + 1);
                }
            }
        }

        return dp[m][n];
    }
}