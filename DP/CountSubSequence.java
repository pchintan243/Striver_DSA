class CountSubSequence {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int num : nums) {
            for(int j = target; j >= num; j--) {
                dp[j] += dp[j- num];
            }
        }
        return dp[target];
    }
}