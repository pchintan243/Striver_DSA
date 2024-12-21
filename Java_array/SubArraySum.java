class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int preSum = 0;
        int cnt = 0;

        Map<Integer, Integer> mpp = new HashMap<>();

        mpp.put(0, 1);

        for(int i = 0; i < n; i++) {

            preSum += nums[i];

            int removal = preSum - k;

            cnt += mpp.getOrDefault(removal, 0);

            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }

        return cnt;
    }
}