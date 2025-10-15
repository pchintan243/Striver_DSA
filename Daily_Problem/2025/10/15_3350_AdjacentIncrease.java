package Daily_Problem.2025.10;
import java.util.List;

class 15_3350_AdjacentIncrease {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();

        int up = 1;
        int preUp = 0;
        int ans = 0;
        for(int i = 1; i < n; i++) {
            if(nums.get(i - 1) < nums.get(i)) {
                up++;
            } else {
                preUp = up;
                up = 1;
            }

            ans = Math.max(ans, Math.min(preUp, up));
            ans = Math.max(ans, up / 2);
        }
        return ans;
    }
}