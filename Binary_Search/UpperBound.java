class UpperBound {
    int upperBound(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        int ans = high + 1;
        
        
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] > k) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}