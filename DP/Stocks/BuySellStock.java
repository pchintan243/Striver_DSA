package Stocks;

public class BuySellStock-I {
  public int stockBuySell(int[] arr, int n) {
    int min = arr[0];
    int ans = 0;
    for (int i = 1; i < n; i++) {
        if(min < arr[i]) {
            ans = Math.max(ans, arr[i] - min);
        } else {
            min = arr[i];
        }
    }

    return ans;
  }
} 
