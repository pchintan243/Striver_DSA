class 23_04_25_1399_CntLargestGroup {
    public int countLargestGroup(int n) {
        int[] dp = new int[40];
        int ans = 0;
        int maxVal = 0;
        for(int i = 1; i <= n; i++) {
            int num = i;
            int sum = 0;
            while(num != 0) {
                int rem = num % 10;
                sum += rem;
                num /= 10;
            }
            dp[sum]++;
            if(maxVal < dp[sum]) {
                ans = 1;
                maxVal = dp[sum];
            } else if(maxVal == dp[sum]) {
                ans++;
            }
        }
        return ans;
    }
}