class Solution {
    public int findMaxEl(int[] arr, int n) {
        int maxEl = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            maxEl = Math.max(maxEl, arr[i]);
        }
        return maxEl;
    }

    public boolean findThreshold(int[] arr, int divisor, int threshold) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] <= divisor) {
                sum++;
            } else if((arr[i] % divisor) == 0){
                sum += (arr[i] / divisor);
            } else {
                sum += (arr[i] / divisor) + 1;
            }
            
        }
        if(sum <= threshold) {
            return true;
        }

        return false;
    }
    
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        if(threshold < n) {
            return -1;
        }

        int maxEl = findMaxEl(nums, n);
        int low = 1;
        int high = maxEl;

        if(threshold == n) {
            return maxEl;
        }

        int ans = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            boolean isValid = findThreshold(nums, mid, threshold);
            if(isValid) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
        // return ans;
    }
}