import java.util.ArrayList;
import java.util.List;
class 228SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return List.of();
        }
        if(n == 1) {
            return List.of(nums[0] + "");
        }
        List<String> ans = new ArrayList<>();
        int prev = nums[0];
        for(int i = 1; i < n; i++) {
            if(nums[i - 1] + 1 != nums[i]) {
                if(prev != nums[i - 1]) {
                    String range = prev + "->" + nums[i - 1];
                    ans.add(range);
                } else {
                    ans.add(prev + "");
                }
                prev = nums[i];
            }
            if(i == n - 1) {
                if(nums[i - 1] + 1 == nums[i]) {
                    String range = prev + "->" + nums[i];
                    ans.add(range);
                } else {
                    ans.add(prev + "");
                }
            }
        }

        return ans;
    }
}