import java.util.Arrays;

public class Solution {
    public static boolean putCows(int []arr, int mid, int k, int n) {
        int cntCows = 1;
        int prevInd = 0;
        for(int i = 1; i < n; i++) {
            if((arr[i] - arr[prevInd]) >= mid) {
                cntCows++;
                prevInd = i;
            }

            if(cntCows == k) {
                return true;
            }
        }
        return false;
    }
    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.

        int n = stalls.length;

        Arrays.sort(stalls);
        int low = 1;
        int high = stalls[n - 1] - stalls[0];
        int ans = Integer.MIN_VALUE;

        while(low <= high) {
            int mid = (low + high) / 2;
            boolean isValid = putCows(stalls, mid, k, n);
            if(isValid) {
                ans = Math.max(mid, ans);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}