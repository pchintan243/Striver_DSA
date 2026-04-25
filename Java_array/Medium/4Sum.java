package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for(int j = i + 1; j < n - 2; j++) {
                if(j > (i + 1) && nums[j] == nums[j - 1]) {
                    continue;
                }
                int sum = target - nums[i] - nums[j];
                int k = j + 1;
                int l = n - 1;

                while(k < l) {
                    int temp = sum - nums[k] - nums[l];
                    if(temp == 0) {
                        ans.add(new ArrayList<>(List.of(nums[i], nums[j], nums[k], nums[l])));
                        k++;
                        l--;

                        while(k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }

                        while(k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    } else if(temp > 0) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return ans;
    }
}