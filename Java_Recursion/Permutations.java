import java.util.ArrayList;
import java.util.List;
public class Permutations {
    void backtrack(int[] nums, int n, List<Integer> temp, List<List<Integer>> ans) {
        if(temp.size() == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < n; i++) {
            if(temp.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            backtrack(nums, n, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, nums.length, new ArrayList<>(), ans);
        return ans;
    }
}