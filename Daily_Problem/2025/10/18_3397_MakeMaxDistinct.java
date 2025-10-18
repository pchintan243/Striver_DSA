package Daily_Problem.2025.10;
import java.util.Arrays;

public class 18_3397_MakeMaxDistinct {
    public int maxDistinctElements(int[] nums, int k) {
        if (nums.length <= (k << 1) + 1) return nums.length;
        Arrays.sort(nums);
        int lastNum = Integer.MIN_VALUE;
        int cnt = 0;
        for(int num: nums) {
            int curr = Math.max(num - k, lastNum + 1);
            if(curr <= num + k) {
                cnt++;
                lastNum = curr;
            }
        }
        return cnt;
    }
}
