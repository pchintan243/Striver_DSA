package Daily_Problem.2025.07;

public class 28_2044_FindMaxOr {
    public int countMaxOrSubsets(int[] nums) {
        int max = findMaxOr(nums);
        return recursive(nums, 0, max, 0);
    }

    private int recursive(int[] nums, int ind, int max, int val) {
        if (ind == nums.length) {
            if (max == val) {
                return 1;
            }
            return 0;
        }
        int p = recursive(nums, ind + 1, max, val | nums[ind]);
        int n = recursive(nums, ind + 1, max, val);
        return p + n;
    }

    private int findMaxOr(int[] nums) {
        int max = 0;
        for (int n : nums) {
            max |= n;
        }
        return max;
    }
}