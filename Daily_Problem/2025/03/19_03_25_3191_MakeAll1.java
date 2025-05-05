class 19_03_25_3191_MakeAll1 {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for(int i = 0; i < n - 2; i++) {
            if(nums[i] == 0) {
                nums[i] ^= 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                cnt++;
            }
        }
        return (nums[n - 2] == 1 && nums[n - 1] == 1) ? cnt : -1;
    }
}