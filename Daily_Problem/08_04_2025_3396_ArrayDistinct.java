class 08_04_2025_3396_ArrayDistinct {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[101];
        for (int i = n - 1; i >= 0; i--) {
            if (dp[nums[i]]) {
                return ((i + 3) / 3);
            }
            dp[nums[i]] = true;
        }

        return 0;
    }
}
