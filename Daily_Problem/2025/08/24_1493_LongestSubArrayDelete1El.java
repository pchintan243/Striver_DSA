package Daily_Problem.2025.08;

public class 24_1493_LongestSubArrayDelete1El {
    public int longestSubarray(int[] nums) {
        int ans = 0;
        int i = 0;
        int n = nums.length;
        int cnt = 0;
        int j = 0;

        while(i < n) {
            if(nums[i] == 0) {
                cnt++;
            }
            if(cnt <= 1) {
                ans = Math.max(ans, i - j + 1 - cnt);
            } else {
                if(nums[j] == 0) {
                    cnt--;
                }
                j++;
            }
            i++;
        }
        return Math.min(ans, n - 1);
    }
}