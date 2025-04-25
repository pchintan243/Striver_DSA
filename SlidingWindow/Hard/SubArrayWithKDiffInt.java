import java.util.HashMap;
import java.util.Map;
class SubArrayWithKDiffInt {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;

        int ans = 0;
        for(int i = 0; i < n - 1; i++) {
            Map<Integer, Integer> mp = new HashMap<>();
            mp.put(nums[i], 1);
            for(int j = i + 1; j < n; j++) {
                mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
                if(mp.size() > k) {
                    break;
                }

                if(mp.size() == k) {
                    ans++;
                }
            }
        }

        return ans;
    }
}