class 12_02_25_2342MaxPairSum {
    int findSum(int n) {
        int ans = 0;
        while(n != 0) {
            int mod = n % 10;
            ans += mod;
            n /= 10;
        }

        return ans;
    }
    public int maximumSum(int[] nums) {
        int ans = -1;
        int[] max = new int[82];
        for(int i = 0; i < nums.length; i++) {
            int sum = findSum(nums[i]);
            int temp = nums[i];
            if(max[sum] != 0) {
                ans = Math.max(ans, temp + max[sum]);
            }
            max[sum] = Math.max(temp, max[sum]);
        }
        
        return ans;
    }
}