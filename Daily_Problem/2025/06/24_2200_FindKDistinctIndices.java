import java.util.ArrayList;
import java.util.List;
public class 24_2200_FindKDistinctIndices {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        // First, collect all indices where nums[j] == key
        List<Integer> keyIndices = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (nums[j] == key) {
                keyIndices.add(j);
            }
        }

        // Now, use a two-pointer approach to scan the array
        int idx = 0;  // pointer for keyIndices
        for (int i = 0; i < n; i++) {
            // Move pointer forward if this key index is too far left
            while (idx < keyIndices.size() && keyIndices.get(idx) < i - k) {
                idx++;
            }
            // If current i is within k of any key index
            if (idx < keyIndices.size() && Math.abs(keyIndices.get(idx) - i) <= k) {
                result.add(i);
            }
        }

        return result;
    }
}