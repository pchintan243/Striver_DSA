class Solution {
    int upperBound(int[] arr, int m, int k) {
        int low = 0;
        int high = m - 1;
        
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] <= k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
        
    }
    
    int smallerCnt(int[][] arr, int m, int n, int mid) {
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            cnt += upperBound(arr[i], m, mid);
        }
        // System.out.println(mid + " " + upperBound(arr[i], m, mid));
        // System.out.println(mid + " " + cnt);
        return cnt;
    }
    int median(int mat[][]) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][m - 1]);
        }
        int req = (n * m) / 2;
        while(low <= high) {
            int mid = (low + high) / 2;
            int func = smallerCnt(mat, m, n, mid);
            if(func <= req) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return low;
    }
}