class 17_04_25_2176_CntEqual {
    public int countPairs(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if((nums[i] == nums[j]) && ((i * j) % k) == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}