class BinarySubArrSum {
    int findCnt(int[] nums, int goal) {
        if(goal < 0) {
            return 0;
        }
        int l = 0;
        int r = 0;
        int n = nums.length;
        int cnt = 0;
        int sum = 0;

        while(r < n) {
            sum += nums[r];
            while(sum > goal) {
                if(nums[l] == 1) {
                    sum--;
                }
                l++;
            }
            cnt = cnt + (r - l + 1);
            r++;
        }

        return cnt;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return findCnt(nums, goal) - findCnt(nums, goal - 1);
    }
}