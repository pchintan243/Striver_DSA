package Medium;

public class 122_BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for(int i = 0; i < n - 1; i++) {
            if(prices[i + 1] > prices[i]) {
                ans += prices[i + 1] - prices[i];
            }
        }
        return ans;
    }
}