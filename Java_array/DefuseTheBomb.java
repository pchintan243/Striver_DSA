class Solution {
    public int[] decrypt(int[] code, int k) {
        int sum = 0;
        int n = code.length;
        int[] ans = new int[n];
        if(k == 0) {
            for(int i = 0; i < n; i++) {
                ans[i] = 0;
            }
        } else if(k > 0) {
            for(int i = 1; i <= k; i++) {
                sum += code[i];
            }
            ans[0] = sum;

            for(int l = 1, r = k + 1; l < n; l++, r++) {
                sum += -code[l] + code[r % n];
                ans[l] = sum;
            }
        } else {
            k = -k;
            for(int i = n - k; i < n; i++) {
                sum += code[i];
            }
            ans[0] = sum;

            for(int l = 0, r = n - k; l < n - 1; l++, r++) {
                sum += code[l] - code[r % n];
                ans[l + 1] = sum;
            }
        }

        return ans;
    }
}
