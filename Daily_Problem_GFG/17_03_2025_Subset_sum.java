class 17_03_2025_Subset_sum {

    static Boolean isSubsetSum(int arr[], int sum) {
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true; // Zero sum is always possible
        
        for (int num : arr) {
            for (int j = sum; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
            if(dp[sum]) {
                return true;
            }
        }
        
        return dp[sum];
    }
}