package Daily_Problem.2026.01;

public class 24_1877_MinimizeMaxPair {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int ans = 0;
        for(int i = 1; i < n; i++) {
            max = Math.max(nums[i], max);
        }
        int[] freq = new int[max + 1];
        for(int i: nums) {
            freq[i]++;
        }
        int a = 0;
        int b = max;

        while(a <= b) {
            if(freq[a] == 0) {
                a++;
                continue;
            }
            if(freq[b] == 0) {
                b--;
                continue;
            }
            ans = Math.max(ans, a + b);
            freq[a]--;
            freq[b]--;
            if(freq[a] == 0) {
                a++;
            }
            if(freq[b] == 0) {
                b--;
            }
        }
        return ans;
    }
}
