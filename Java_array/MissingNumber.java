class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int max = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            if(max < nums[i]) {
                max = nums[i];
            }
        }
        int realSum = (n * (n + 1)) / 2;
        if(realSum == sum && max == n - 1) {
            return n;
        } else if(realSum == sum) {
            return 0;
        } else {
            return realSum - sum;
        }
    }
}