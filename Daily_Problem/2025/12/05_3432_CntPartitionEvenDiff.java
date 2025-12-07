package Daily_Problem.2025.12;

public class 05_3432_CntPartitionEvenDiff {
    public int countPartitions(int[] nums) {
        int sum = 0;
        for(int i: nums) {
            sum += i;
        }
        int cnt = 0;
        int total = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            total += nums[i];
            sum -= nums[i];
            if(((total - sum) % 2) == 0) {
                cnt++;
            }
        }

        return cnt;
    }
}