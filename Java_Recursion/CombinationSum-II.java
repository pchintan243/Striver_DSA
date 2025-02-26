class CombinationSum-II {
    
    List<Integer> temp = new ArrayList<>();

    public void generateComb(int ind, int[] num, int target, List<List<Integer>> ans, List<Integer> temp) {
        if(target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = ind; i < num.length; i++) {
            if(i > ind && num[i] == num[i - 1]) continue;
            if(num[i] > target) break;
            temp.add(num[i]);
            generateComb(i + 1, num, target - num[i], ans, temp);
            temp.remove(temp.size() - 1);
        }

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        generateComb(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
}