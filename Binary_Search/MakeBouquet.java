class Solution {
    public int findMaxEl(int[] bloomDay, int n) {
        int maxEl = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            maxEl = Math.max(maxEl, bloomDay[i]);
        }
        return maxEl;
    }

    public int findMinEl(int[] bloomDay, int n) {
        int minEl = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            minEl = Math.min(minEl, bloomDay[i]);
        }
        return minEl;
    }

    public boolean checkBloom(int[] arr, int day, int m, int k) {
        int cntBouq = 0;
        int adj = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] <= day) {
                adj++;
            } else {
                adj = 0;
                continue;
            }

            if(adj == k) {
                adj = 0;
                cntBouq++;
            }
            if(cntBouq == m) {
                return true;
            }
        }

        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((m * k) > n) {
            return -1;
        }

        int maxEl = findMaxEl(bloomDay, n);
        int low = findMinEl(bloomDay, n);
        int high = maxEl;

        if((m * k) == n) {
            return maxEl;
        }

        int ans = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            boolean isValid = checkBloom(bloomDay, mid, m, k);
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