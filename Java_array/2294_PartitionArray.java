import java.util.Arrays;
class 2294_PartitionArray {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 1;
        int min = nums[0];
        for(int i = 1; i < n; i++) {
            if(nums[i] - min > k) {
                ans++;
                min = nums[i];
            }
        }

        return ans;
    }
}