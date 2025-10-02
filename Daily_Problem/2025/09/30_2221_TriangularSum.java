package Daily_Problem.2025.09;

public class 30_2221_TriangularSum {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        for(int i = n - 2; i >= 0; i--) {
            for(int k = 0; k <= i; k++) {
                nums[k] = (nums[k] + nums[k + 1]) % 10;
            }
        }
        return nums[0];
    }
}