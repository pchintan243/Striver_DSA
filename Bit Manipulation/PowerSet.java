class PowerSet {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        int n = 1 << nums.length;
        for(int i = 0; i < n; i++) {
            List<Integer> res = new ArrayList<>();
            for(int j = 0; j < nums.length; j++) {
                if((i & (1 << j)) > 0) {
                    res.add(nums[j]);
                }
            }
            ans.add(res);
        }
        return ans;
    }
}