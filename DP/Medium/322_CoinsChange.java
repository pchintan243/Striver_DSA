package Medium;
import java.util.Arrays;

public class 322_CoinsChange {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        int n = coins.length;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int coin : coins) {
            for(int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] <= amount ? dp[amount] : -1;
    }       
}