class CntNiceSubArray {
    public int findMax(int[] nums, int k) {
        int n = nums.length;
        if(k < 0) {
            return 0;
        }
        int l = 0;
        int r = 0;
        int ans = 0;
        int cnt = 0;
        while(r < n) {
            if((nums[r] % 2) == 1) {
                cnt++;
            }
            
            while(cnt > k) {
                if((nums[l++] & 1) == 1) {
                    cnt--;
                    break;
                }
            }
            ans += (r - l + 1);

            r++;
        }
        return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return findMax(nums, k) - findMax(nums, k - 1);
    }
}

// 1 1 2 2 1
// 1 1 