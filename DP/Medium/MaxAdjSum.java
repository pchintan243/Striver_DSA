package Medium;

public class MaxAdjSum {
    public int nonAdjacent(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }
        int prev1 = Math.max(nums[0], nums[1]);
        if(n == 2) {
            return prev1;
        }
        int prev2 = nums[0];
        for(int i = 2; i < n; i++) {
            int pick = nums[i] + prev2;
            int curr = Math.max(pick, prev1);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}