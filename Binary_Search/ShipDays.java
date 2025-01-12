class Solution {
    int[] findMaxAndSum(int[] arr, int n) {
        int maxEl = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            maxEl = Math.max(maxEl, arr[i]);
        }

        return new int[] {maxEl, sum}; // Return both values in an array
    }


    Boolean findDays(int[] weights, int cap, int days) {
        int daysCnt = 1; //First day.
        int load = 0;
        int n = weights.length; //size of array.
        for (int i = 0; i < n; i++) {
            if ((load + weights[i]) > cap) {
                daysCnt += 1; //move to next day
                load = weights[i]; //load the weight.
            } else {
                //load the weight on the same day.
                load += weights[i];
            }
        }
        if(daysCnt <= days) {
            return true;
        }
        return false;
    }

    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        if(n < days) {
            return -1;
        }
        int low = findMaxAndSum(weights, n)[0];
        int high = findMaxAndSum(weights, n)[1];

        if(n == days) {
            return low;
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