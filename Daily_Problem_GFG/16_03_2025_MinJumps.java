class 16_03_2025_MinJumps {
    static int minJumps(int[] arr) {
        // code here
        if(arr[0] == 0) {
            return -1;
        }
        int cnt = 0;
        int maxVal = Integer.MIN_VALUE;
        int current = 0;
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            maxVal = Math.max(maxVal, i + arr[i]);
            if(current == i) {
                if(i != n - 1) {
                    cnt++;
                }
                current = maxVal;
            } else {
                continue;
            }
        }
        
        if(current < n - 1) {
            return -1;
        }
        
        return cnt;
    }
}