class 17_03_25_2206_DivideArray {
    public boolean divideArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int xor = nums[0];
        for(int i = 1; i < n; i = i + 2) {
            if(nums[i] != nums[i - 1]) {
                return false;
            }
        }

        return true;
    }
}