class 16_2016_maxDiff {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int[] maxNum = new int[n];
        maxNum[n - 1] = 0;
        for(int i = n - 2; i >= 0; i--) {
            maxNum[i] = Math.max(nums[i + 1], maxNum[i + 1]);
        }
        int ans = -1;
        for(int i = 0; i < n - 1; i++) {
            if(maxNum[i] - nums[i] > 0) {
                ans = Math.max(ans, maxNum[i] - nums[i]);
            }
        }

        return ans;
    }
}