class N_th_rootOf_M {
    public int nthRoot(int n, int m) {
        // code here
        int low = 1;
        int high = m;
        
        if(n == 1) {
            return m;
        }
        
        while(low <= high) {
            int mid = (low + high) / 2;
            int num = (int) Math.pow(mid, n);
            if(num == m) {
                return mid;
            } else if(num < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}