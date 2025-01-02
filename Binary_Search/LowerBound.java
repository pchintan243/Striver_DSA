class LowerBound {
    static int findFloor(int[] arr, int k) {
        // write code here
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        
        
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] <= k) {
                ans = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        return ans;
    }
}