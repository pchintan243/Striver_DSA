public class 22_1695_MaxEraseValue {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[10001];

        int ans = 0;
        int maxAns = 0;
        int left = 0;

        for(int right = 0; right < nums.length; right++) {
            while(seen[nums[right]]) {
                seen[nums[left]] = false;
                maxAns -= nums[left++];
            }
            maxAns += nums[right];
            seen[nums[right]] = true;
            ans = Math.max(maxAns, ans);
        }
        return ans;
    }
}