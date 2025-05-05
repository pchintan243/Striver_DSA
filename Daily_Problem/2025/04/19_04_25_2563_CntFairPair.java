import java.util.Arrays;
class 19_04_25_2563_CntFairPair {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long ans = 0;
        int n = nums.length;
        Arrays.sort(nums);

        long cntUpper = 0;
        int i = 0;
        int j = n - 1;
        while(i < j) {
            if(nums[i] + nums[j] <= upper) {
                cntUpper += (j - i);
                i++;
            } else {
                j--;
            }
        }

        long cntLower = 0;
        i = 0;
        j = n - 1;
        while(i < j) {
            if(nums[i] + nums[j] < lower) {
                cntLower += (j - i);
                i++;
            } else {
                j--;
            }
        }
        return cntUpper - cntLower;
    }
}