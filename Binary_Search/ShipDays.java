class Solution {
    int findMax(int[] arr, int n) {
        int maxEl = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            maxEl = Math.max(maxEl, arr[i]);
        }

        return maxEl;
    }

    int findSum(int[] arr, int n) {
        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += arr[0];
        }

        return sum;
    }

    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        if(n < days) {
            return -1;
        }
        int low = findMax(weights, n);
        int high = findSum(weights, n);

        if(n == days) {
            return high;
        }

        int ans = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            boolean isValid = findDays(weights, mid, days);
            if(isValid) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}