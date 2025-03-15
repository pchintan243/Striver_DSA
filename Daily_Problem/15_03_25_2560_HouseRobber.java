class 15_03_25_2560_HouseRobber {
    boolean canPoss(int[] nums, int k, int mid) {
        int cnt = 0;
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= mid) {
                ans = Math.max(ans, nums[i]);
                cnt++;
                i++;
            }
        }
        return cnt >= k;
    }
    public int minCapability(int[] nums, int k) {
        int low = Arrays.stream(nums).min().getAsInt();
        int high = Arrays.stream(nums).max().getAsInt();
        if(k == 1) {
            return low;
        }
        int ans = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = (low + high) >> 1;
            if(canPoss(nums, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}