class 29_04_25_2962_CntKElement {
    public long countSubarrays(int[] nums, int k) {
        long ans = 0;
        int n = nums.length;
        int maxEl = 0;
        for(int i = 0; i < n; i++) {
            maxEl = Math.max(maxEl, nums[i]);
        }

        int cnt = 0;
        int r = n - 1;
        int l = n - 1;
        while(r >= 0) {
            if(nums[r] == maxEl) {
                cnt++;
            }
            if(cnt == k) {
                ans += r + 1;
            }

            while(cnt == k && l >= r) {
                if(nums[l] == maxEl)
                    cnt--;
                else
                    ans += r + 1;
                l--;
            }       
            r--;
        }

        return ans;
    }
}