class 26_04_2025_2444_CntSubArray {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int n = nums.length;
        int start = -1;
        int minInd = -1;
        int maxInd = -1;

        for(int i = 0; i < n; i++) {
            

            if(nums[i] < minK || nums[i] > maxK) {
                start = i;
            }
            if(nums[i] == minK)
                minInd = i;
            if(nums[i] == maxK)
                maxInd = i;
            int valid = Math.max(0, Math.min(minInd, maxInd) - start);
            ans += valid;
            
        }

        return ans;
    }
}