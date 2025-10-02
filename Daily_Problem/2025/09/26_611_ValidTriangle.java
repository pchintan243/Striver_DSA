package Daily_Problem.2025.09;
import java.util.Arrays;

public class 26_611_ValidTriangle {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);
        for(int i = 0; i < n - 2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                for(int k = n - 1; k >= j + 1; k--) {
                    if(nums[i] + nums[j] > nums[k] &&
                    nums[i] + nums[k] > nums[j] &&
                    nums[k] + nums[j] > nums[i]) {
                        ans += k - j;
                        break;
                    }
                }
            }
        }

        return ans;
    }
}