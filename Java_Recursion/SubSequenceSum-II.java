class SubSequenceSum-II {
    
    List<Integer> temp = new ArrayList<>();

    public void generateComb(int ind, int[] num, int target, List<List<Integer>> ans, List<Integer> temp) {
        if(ind >= num.length) {
            if(target == 0) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        if(target >= num[ind]) {
            temp.add(num[ind]);
            generateComb(ind, num, target - num[ind], ans, temp);
            temp.remove(temp.size() - 1);
        }
        generateComb(ind + 1, num, target, ans, temp);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        generateComb(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
}