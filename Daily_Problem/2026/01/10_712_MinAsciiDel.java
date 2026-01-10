package Daily_Problem.2026.01;

public class 10_712_MinAsciiDel {
    public int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for(int i = 0; i < n1; i++) {
            for(int j = 0; j < n2; j++) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + s1.charAt(i);
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        int total = 0;
        for(char c: s1.toCharArray()) {
            total += c;
        }

        for(char c: s2.toCharArray()) {
            total += c;
        }
        return total - 2 * dp[n1][n2];
    }
}