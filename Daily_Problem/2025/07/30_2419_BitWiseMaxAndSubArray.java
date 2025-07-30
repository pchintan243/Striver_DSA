public class 30_2419_BitWiseMaxAndSubArray {
    public int longestSubarray(int[] nums) {
        int target = findMaxAnd(nums);
        int maxLength = 0;
        int currentLength = 0;
        for (int num : nums) {
            if (num == target) {
                currentLength++;
            } else {
                currentLength = 0;
            }
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }

    public int findMaxAnd(int[] nums) {
        int max = 0;
        for(int i: nums) {
            max = Math.max(max, i);
        }

        return max;
    }
}