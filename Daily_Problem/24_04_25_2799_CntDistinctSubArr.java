import java.util.HashMap;
import java.util.Map;
class 24_04_25_2799_CntDistinctSubArr {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int ans = 0;
        Set<Integer> set = new HashSet<>();

        for(int val : nums){
            set.add(val);
        }

        int k = set.size();
        Map<Integer, Integer> mp = new HashMap<>();

        while(r < n) {
            mp.put(nums[r], mp.getOrDefault(nums[r], 0) + 1);

            while(mp.size() == k) {
                ans += (n - r);

                if(mp.get(nums[l]) == 1) {
                    mp.remove(nums[l]);
                } else {
                    mp.put(nums[l], mp.get(nums[l]) - 1);
                }
                l++;
            }

            r++;
        }
        return ans;
    }
}