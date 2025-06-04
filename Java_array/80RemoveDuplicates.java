import java.util.Map;
class 80RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        int[] arr = new int[n];
        Map<Integer, Integer> mp = new LinkedHashMap<>();
        for(int i = 0; i < n; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        int ind = 0;
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if(entry.getValue() > 1) {
                nums[ind++] = entry.getKey();
                nums[ind++] = entry.getKey();
                cnt += 2;
            } else {
                nums[ind++] = entry.getKey();
                cnt++;
            }
        }

        return cnt;
    }
}