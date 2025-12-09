package Daily_Problem.2025.12;

public class 09_3583_CntSpecialTriple {
    public int specialTriplets(int[] nums) {
        int MOD = (int) 1e9 + 7;
        int[] left = new int[100001];
        int[] right = new int[100001];
        int ans = 0;
        int n = nums.length;
        for (int num : nums) {
            right[num]++;
        }

        for(int num: nums) {
            right[num]--;
            int t = num << 1;

            if (t < 100001) {
                ans = (ans + (int) ((1L * left[t] * right[t]) % MOD)) % MOD;
            }
            left[num]++;
        }

        return ans;
    }
}