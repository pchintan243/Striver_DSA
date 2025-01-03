class FindSQRT {
    int floorSqrt(int n) {
        // Your code here
        int low = 1;
        int high = n;
        
        while(low <= high) {
            int mid = (low + high) / 2;
            int sq = mid * mid;
            if(sq == n) {
                return mid;
            } else if(sq < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }
}