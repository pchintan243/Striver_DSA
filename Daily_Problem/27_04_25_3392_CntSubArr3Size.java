class 27_04_25_3392_CntSubArr3Size {
    public int countSubarrays(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i < n - 2; i++) {
            int temp = nums[i] + nums[i + 2];

            if((temp * 2) == nums[i + 1]) {
                ans++;
            }
        }

        return ans;
    }
}