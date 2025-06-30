package Daily_Problem;
import java.util.Arrays;

class 30_594_HarmoniousSequence {
    public int findLHS(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);
        int i = 1;
        int j = 0;
        
        while(i < n && j < n) {
            if(nums[j] == nums[i]) {
                i++;
                continue;
            }
            if(nums[j] + 1 == nums[i]) {
                ans = Math.max(ans, i - j + 1);
                i++;
                continue;
            }
            j++;
        }
        return ans;
    }
}