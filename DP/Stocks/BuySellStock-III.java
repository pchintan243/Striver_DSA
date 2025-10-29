package Stocks;
import java.util.Arrays;

public class BuySellStock-III {
    int recursion(int[] arr, int n, int buy, int ind, int total, int[][][] dp) {
        if(ind == n || total == 2) {
            return 0;
        }
        if(dp[ind][buy][total] != -1) {
            return dp[ind][buy][total];
        }
        int profit = 0;
        if(buy == 0) {
            profit = Math.max(recursion(arr, n, 0, ind + 1, total, dp), recursion(arr, n, 1, ind + 1, total, dp) - arr[ind]);
        } else {
            profit = Math.max(recursion(arr, n, 1, ind + 1, total, dp), recursion(arr, n, 0, ind + 1, total + 1, dp) + arr[ind]);
        }
        
        return dp[ind][buy][total] = profit;
    }
    public int stockBuySell(int[] arr, int n) {
        int[][][] dp = new int[n][2][3];
        for(int[][] i: dp) {
            for(int[] j: i) {
                Arrays.fill(j, -1);
            }
        }
        return recursion(arr, n, 0, 0, 0, dp);
    }
}

