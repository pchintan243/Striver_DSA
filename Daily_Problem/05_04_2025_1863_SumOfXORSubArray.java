class 05_04_2025_1863_SumOfXORSubArray {
    public int subsetXORSum(int[] nums) {
        int ans = 0;
        for(int n : nums) {
            ans = ans | n;
        }

        return ans * (1 << (nums.length - 1));
    }
}