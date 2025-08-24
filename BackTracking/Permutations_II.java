package BackTracking;
import java.util.ArrayList;
import java.util.List;

public class Permutations_II {
    Set<Integer> st;
    List<List<Integer>> ans;
    void backtrack(int[] nums, int n, List<Integer> lst) {
        if(lst.size() == n) {
            if(!ans.contains(lst))
                ans.add(new ArrayList<>(lst));
            return;
        }
        for(int i = 0; i < n; i++) {
            if(st.contains(i)) {
                continue;
            }
            st.add(i);
            lst.add(nums[i]);
            backtrack(nums, n, lst);
            lst.remove(lst.size() - 1);
            st.remove(i);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        st = new HashSet<>();
        ans = new ArrayList<>();
        backtrack(nums, nums.length, new ArrayList<>());
        return ans;
    }
}