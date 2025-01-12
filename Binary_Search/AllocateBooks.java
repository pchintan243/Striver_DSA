import java.util.ArrayList;
public class Solution {
    static int[] findMaxAndSum(ArrayList<Integer> arr, int n) {
        int maxEl = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr.get(i);
            maxEl = Math.max(maxEl, arr.get(i));
        }

        return new int[] {maxEl, sum}; // Return both values in an array
    }
    static boolean setAllocation(ArrayList<Integer> arr, int n, int m, int mid) {
        int cnt = 1;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            if((sum + arr.get(i)) <= mid) {
                sum += arr.get(i);
            } else {
                sum = arr.get(i);
                cnt++;
            }   
        }

        if(cnt <= m) {
            return true;
        }
        return false;
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.

        if(n < m) {
            return -1;
        }

        int low = findMaxAndSum(arr, n)[0];
        int high = findMaxAndSum(arr, n)[1];

        if(n == m) {
            return low;
        }

        if(m == 1) {
            return high;
        }
        
        int ans = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = (low + high) / 2;
            boolean isValid = setAllocation(arr, n, m, mid);
            if(isValid) {
                high = mid - 1;
                ans = Math.min(ans, mid);
            } else {
                low = mid + 1;
            }
        }

        return low;
        // return ans;
    }
}