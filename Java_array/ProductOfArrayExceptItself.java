public class ProductOfArrayExceptItself {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;
        for(int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        // 1 1 2 8

        int postFix = 1;
        for(int i = n - 1; i >= 0; i--) {
            res[i] *= postFix;
            postFix *= nums[i];
        }

        // 1 8
        // 1 1 2 8

        return res;
    }
}  

