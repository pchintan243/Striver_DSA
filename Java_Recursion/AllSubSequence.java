class AllSubSequence {
    List<List<Integer>> ans = new ArrayList<>();

    List<Integer> res = new ArrayList<>();
    public List<List<Integer>> generateSubset(int[] nums, int ind) {
        if(ind >= nums.length) {
            ans.add(new ArrayList<>(res));
            return ans;
        }
        res.add(nums[ind]);
        generateSubset(nums, ind + 1);
        res.remove(res.size() - 1);
        generateSubset(nums, ind + 1);

        return ans;
    }
    public List<List<Integer>> subsets(int[] nums) {
        generateSubset(nums, 0);
        return ans;
    }
}