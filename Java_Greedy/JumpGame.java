public class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return true;
        }
        int i = 0;
        int max = 0;
        while(i < n && max < n) {
            if(i == max && nums[i] == 0) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
            if(max >= n - 1) {
                return true;
            }
            i++;
        }
        return false;
    }
}