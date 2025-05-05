class 07_04_2025_416_PartitionSubSetSum {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if(sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        Arrays.fill(dp, false);

        dp[0] = true;
        for(int num : nums) {
            for(int i = sum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
                if(dp[sum]) {
                    return true;
                }
            }
        }
        return dp[sum];
    }
}