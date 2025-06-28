import java.util.Map;
class 28_2099_FindSubSequence {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        Map<Integer, Integer> mp = new TreeMap<>();
        while(k-- > 0) {
            int max = Integer.MIN_VALUE;
            int ind = 0;
            for(int i = 0; i < n; i++) {
                if(max < nums[i]) {
                    max = nums[i];
                    ind = i;
                }
            }
            nums[ind] = Integer.MIN_VALUE;
            mp.put(ind, max);
        }
        int i = 0;
        for(Map.Entry<Integer, Integer> data : mp.entrySet()) {
            ans[i++] = data.getValue();
        }

        return ans;
    }
}