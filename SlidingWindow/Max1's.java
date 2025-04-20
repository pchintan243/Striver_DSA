class Max1's {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int ans = 0;
        int zeroCnt = 0;

        while(r < n) {
            if(nums[r] == 0) {
                zeroCnt++;
            }
            if(zeroCnt > k) {
                if(nums[l] == 0) {
                    zeroCnt--;
                }
                l++;
            } else {
                ans = Math.max(ans, r - l + 1);
            }
            r++;
        }

        return ans;
    }
}