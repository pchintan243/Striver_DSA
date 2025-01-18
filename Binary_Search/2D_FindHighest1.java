class Solution {
    public int lowerBound(int arr[], int k) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] >= k) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            } 
        }
        
        return ans;
    }
    public int rowWithMax1s(int arr[][]) {
        // code here
        int n = arr.length;
        int m = arr[0].length;
      
        int ans = -1;
        int cnt = 0;
        
        for(int i = 0; i < n; i++) {
            int ind = m - lowerBound(arr[i], 1);
            if(cnt < ind) {
                cnt = ind;
                ans = i;
            }
            if(cnt == m) {
                break;
            }
        }
        
        return ans;
    }
}