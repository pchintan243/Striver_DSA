class MaxProductSubArray {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int prefixSum = 1;
        int suffixSum = 1;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(prefixSum == 0) {
                prefixSum = 1;
            }
            if(suffixSum == 0) {
                suffixSum = 1;
            }
            prefixSum *= nums[i];
            suffixSum *= nums[n - i - 1];

            if(prefixSum > maxProduct) {
                maxProduct = prefixSum;
            }
            if(suffixSum > maxProduct) {
                maxProduct = suffixSum;
            }
        }
        return maxProduct;
    }
}