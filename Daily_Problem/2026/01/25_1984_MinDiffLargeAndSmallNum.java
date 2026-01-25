package Daily_Problem.2026.01;
import java.util.Arrays;

public class 25_1984_MinDiffLargeAndSmallNum {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i = 0; i <= n - k; i++) {
            ans = Math.min(ans, nums[i + k - 1] - nums[i]);
        }
        return ans;
    }
}