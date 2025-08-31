package Medium;

public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int result = 0;

        int prev2 = 0;
        int prev1 = nums[0];

        for (int i = 1; i < n; i++) {
            int pick = prev2 + nums[i]; // rob this house
            int skip = prev1;               // skip this house
            int currMax = Math.max(pick, skip);
            
            prev2=prev1;
            prev1=currMax;
        }

        return prev1;
    }
}