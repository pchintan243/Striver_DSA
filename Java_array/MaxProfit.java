public class MaxProfit {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            // Update the minimum price encountered so far
            if (price < minPrice) {
                minPrice = price;
            }
            // Calculate profit and update the max profit if it's higher
            else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}