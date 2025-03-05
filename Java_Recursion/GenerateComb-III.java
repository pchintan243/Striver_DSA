class GenerateComb-III {
    public void generateComb(int k, int n, int num, int sum, List<List<Integer>> ans, List<Integer> temp) {
        if(temp.size() == k) {
            if(sum == n) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        for(int i = num + 1; i <= 9; i++) {
            if(sum + i > n)
                break;
            temp.add(i);
            generateComb(k, n, i, sum + i, ans, temp);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(n < k) {
            return List.of();
        }
        List<List<Integer>> ans = new ArrayList<>();
        generateComb(k, n, 0, 0, ans, new ArrayList<>());
        return ans;
    }
}