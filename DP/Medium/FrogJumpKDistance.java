package Medium;

public class FrogJumpKDistance {
    public int frogJump(int[] heights, int k) {
        int n = heights.length;

        if(n <= k) {
            return Math.abs(heights[n - 1] - heights[0]);
        }
        int[] dp = new int[k];
        for(int i = 1; i < n; i++) {
            int jump1 = Integer.MAX_VALUE;
            for(int j = 1; j <= k; j++) {
                if(i - j >= 0) {
                    jump1 = Math.min(jump1, Math.abs(heights[j] - heights[i]));
                }
                dp[i % j] = jump1;
            }
        }

        return dp[n - 1];
    }
}