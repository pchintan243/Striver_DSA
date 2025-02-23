public class CheckSubSequenceSumExist {
    public static boolean isSubsetPresent(int n, int k,int []a) {
        // Write your code here
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for(int t: a) {
            for(int j = k; j >= t; j--) {
                dp[j] += dp[j- t];
                if(dp[k] > 0) {
                    return true;
                }
            }
        }
        return false;
    }
}