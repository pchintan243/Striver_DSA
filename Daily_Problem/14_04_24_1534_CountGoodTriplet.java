class 14_04_24_1534_CountGoodTriplet {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int cnt = 0;
        for(int i = 0; i < n - 2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                int sub1 = Math.abs(arr[i] - arr[j]);
                if(sub1 <= a) {
                    for(int k = j + 1; k < n; k++) {
                        int sub2 = Math.abs(arr[j] - arr[k]);
                        if(sub2 <= b) {
                            int sub3 = Math.abs(arr[k] - arr[i]);
                            if(sub3 <= c) {
                                cnt++;
                            }
                        }
                    }
                }
            }
        }

        return cnt;
    }
}