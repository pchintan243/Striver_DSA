class SubsetSum-I {
    public ArrayList<Integer> generateSum(int[] arr, int sum, ArrayList<Integer> ans, int ind) {
        if(ind >= arr.length) {
            ans.add(sum);
            return ans;
        }
        
        generateSum(arr, sum + arr[ind], ans, ind + 1);
        
        generateSum(arr, sum, ans, ind + 1);
        return ans;
        
    }
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        generateSum(arr, 0, ans, 0);
        
        return ans;
    }
}