package Medium;

public class FrogJump {
    public int frogJump(int[] heights) {
        int n = heights.length;
        if(n == 1) {
            return 0;
        }

        int prev1 = Math.abs(heights[0] - heights[1]);
        int prev2 = 0;
        for(int i = 2; i < n; i++) {
            int jump1 = prev1 + Math.abs(heights[i] - heights[i - 1]);
            int jump2 = prev2 + Math.abs(heights[i] - heights[i - 2]);
            int curr = Math.min(jump1, jump2);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
