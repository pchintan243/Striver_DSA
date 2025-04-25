import java.util.Arrays;
class SubArrayWithKDiffIntOptimal {
    public int findSum(int[] nums, int k) {

        int n = nums.length;

        int ans = 0;

        int l = 0;
        int r = 0;
        int[] dp = new int[20001];
        Arrays.fill(dp, -1);
        int cnt = 0;
        while(r < n) {
            if(dp[nums[r]] == -1) {
                cnt++;
                dp[nums[r]] = 1;
            } else {
                dp[nums[r]]++;
            }

            while(cnt > k) {
                if(dp[nums[l]] == 1) {
                    dp[nums[l++]] = -1;
                    cnt--;
                    break;
                }
                dp[nums[l++]]--;
            }

            ans += (r - l + 1);
            r++;
        }

        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return findSum(nums, k) - findSum(nums, k - 1);
    }
}