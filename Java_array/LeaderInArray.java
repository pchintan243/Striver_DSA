class LeaderInArray {
    static ArrayList<Integer> leaders(int arr[]) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        int maxEl = Integer.MIN_VALUE;
        for(int i = arr.length - 1; i >= 0; i--) {
            if(maxEl <= arr[i]) {
                maxEl = arr[i];
                ans.add(maxEl);
            }
        }
        
        for(int i = 0; i < ans.size() / 2; i++) {
            int temp = ans.get(i);
            ans.set(i, ans.get(ans.size() - i - 1));
            ans.set(ans.size() - i - 1, temp);
        }
        return ans;
    }
}