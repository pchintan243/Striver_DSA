import java.util.Arrays;
class 09_04_2025_3375_MinToMakeK {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        if(nums[0] < k) {
            return -1;
        }
        int n = nums.length;
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] > k) {
                cnt++;
                while(i + 1 < n && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }

        return cnt;
    }
}