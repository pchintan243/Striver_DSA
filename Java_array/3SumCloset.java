import java.util.Arrays;
class 3SumCloset {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int r = n - 1;
        int minDiff = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        for(int l = 0; l < n - 2; l++) {
            int k = l + 1;
            while(k < r) {
                int sum = nums[l] + nums[r] + nums[k];
                int diff = Math.abs(sum - target);

                if(minDiff > diff) {
                    ans = sum;
                    minDiff = diff;
                }
                if(sum == target) {
                    return sum;
                } else if(sum < target) {
                    k++;
                } else {
                    r--;
                }
            }
            r = n - 1;
        }
        return ans;
    }
}