package Daily_Problem.2025.07;

public class 27_2210_CountValleysHills {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int ans = 0;

        int prev = nums[0];
        for(int i = 1; i < n - 1; i++) {
            if(nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int curr = nums[i];
            int next = nums[j];
            while(j < n - 1 && curr == next) {
                next = nums[++j];
            }
            if(j == n)
                break;
            if((curr < prev && curr < next) || (curr > prev && curr > next)) {
                ans++;
                prev = curr;
            }
        }
        return ans;
    }
}