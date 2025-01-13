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

    boolean splitCnt(int[] arr, int n, int k, int mid) {
        int cnt = 1;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            if((sum + arr[i]) <= mid) {
                sum += arr[i];
            } else {
                sum = arr[i];
                cnt++;
            }   
        }

        if(cnt <= k) {
            return true;
        }
        return false;
    }

    public int splitArray(int[] arr, int k) {
        int n = arr.length;
        if(n < k) {
            return -1;
        }

        int low = findMaxAndSum(arr, n)[0];
        int high = findMaxAndSum(arr, n)[1];

        if(n == k) {
            return low;
        }

        if(k == 1) {
            return high;
        }
        
        int ans = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = (low + high) / 2;
            boolean isValid = splitCnt(arr, n, k, mid);
            if(isValid) {
                high = mid - 1;
                ans = Math.min(ans, mid);
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}