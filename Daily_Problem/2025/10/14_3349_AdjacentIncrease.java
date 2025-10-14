package Daily_Problem.2025.10;
import java.util.List;

public class 14_3349_AdjacentIncrease {
    private boolean isIncreasing(List<Integer> nums, int start, int k) {
        for(int i = start; i < start + k - 1; i++) {
            if(nums.get(i) >= nums.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int stop = 2 * k;
        for(int i = 0; i + stop <= n; i++) {
            if(isIncreasing(nums, i, k) && isIncreasing(nums, i + k, k)) {
                return true;
            }
        }

        return false;
    }

}