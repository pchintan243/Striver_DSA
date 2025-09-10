import java.util.HashMap;
import java.util.Map;
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int max = 0;
        for(int num: nums) {
            if(!mp.containsKey(num)) {
                mp.put(num, mp.getOrDefault(num - 1, 0) + 
                mp.getOrDefault(num + 1, 0) + 1);

                mp.put(num - mp.getOrDefault(num - 1, 0), mp.get(num));
                mp.put(num + mp.getOrDefault(num + 1, 0), mp.get(num));
                max = Math.max(max, mp.get(num));
            }
        }
        return max;
    }
}
