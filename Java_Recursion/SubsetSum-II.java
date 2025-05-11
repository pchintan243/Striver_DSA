import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class SubsetSum-II {
    public void generateSum(int[] nums, List<List<Integer>> ans, List<Integer> temp, int ind) {
            ans.add(new ArrayList<>(temp));
        
        for(int j = ind; j < nums.length; j++) {
            if(j > ind && nums[j] == nums[j - 1])
                continue;
            temp.add(nums[j]);
            generateSum(nums, ans, temp, j + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        generateSum(nums, ans, new ArrayList<>(), 0);

        return ans;
    }
}