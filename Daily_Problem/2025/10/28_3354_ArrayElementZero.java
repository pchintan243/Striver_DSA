package Daily_Problem.2025.10;

class 28_3354_ArrayElementZero {
    public int countValidSelections(int[] nums) {
        int len = nums.length, count = 0, left = 0, right = 0;
        for(int i: nums) {
            right += i;
        }
        for (int i = 0; i < len; i++) {
            left += nums[i];
            if (nums[i] != 0) continue;
            if (2 * left == right) count += 2;
            if (Math.abs(2 * left - right) == 1) count++;
        }
        return count;
    }
}