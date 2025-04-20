package Contest.154_Biweekly;

class MinOperation {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for(int i : nums) {
            sum += i;
        }
        
        if(sum % k == 0) {
            return 0;
        }
        
        if(sum < k) {
            return sum;
        }
        return sum % k;
    }
}