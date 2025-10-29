package Stocks;

public class BuySellStock-II {
    public int stockBuySell(int[] arr, int n) {
        int ans = 0;
        for(int i = 1; i < n; i++) {
            if(arr[i - 1] < arr[i]) {
                ans += arr[i] - arr[i - 1];
            }
        }
        return ans;
    }    
}
