package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < n - 2; i++) {
            if(nums[i] > 0)
                break;
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int k = i + 1;
            int j = n - 1;
            while(k < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    ans.add(new ArrayList<>(List.of(nums[i], nums[k], nums[j])));
                    k++;
                    j--;
                    while(k < j && nums[k] == nums[k - 1]) {
                        k++;
                    }
                } else if(sum < 0) {
                    k++;
                } else {
                    j--;
                }
            }
        }

        return ans;
    }
}
