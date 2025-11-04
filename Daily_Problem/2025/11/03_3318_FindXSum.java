package Daily_Problem.2025.11;

class 03_3318_FindXSum {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;

        int[] ans = new int[n - k + 1];
        for(int i = 0; i <= n - k; i++) {
            ans[i] = computeSum(i, i + k - 1, nums, x);
        }

        return ans;
    }

    public int computeSum(int l, int r, int[] nums, int x) {
        int[] freq = new int[51];
        int sum = 0;
        int distinctCnt = 0;

        for(int i = l; i <= r; i++) {
            sum += nums[i];
            if(freq[nums[i]] == 0) {
                distinctCnt++;
            }
            freq[nums[i]]++;
        }

        if(distinctCnt < x) {
            return sum;
        }
        sum = 0;
        for(int pick = 0; pick < x; pick++) {
            int bestFreq = -1;
            int bestVal = -1;

            for(int val = 50; val >= 0; val--) {
                if(freq[val] > bestFreq) {
                    bestFreq = freq[val];
                    bestVal = val;
                }
            }
            if(bestVal != -1) {
                sum += (bestVal * bestFreq);
                freq[bestVal] = 0;
            }
        }
        return sum;
    }
}