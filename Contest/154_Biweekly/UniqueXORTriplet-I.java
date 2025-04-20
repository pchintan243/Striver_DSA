package Contest.154_Biweekly;

class UniqueXORTriplet-I {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n <= 2) {
            return n;
        }
        
        int cnt = 0;
        while((n >> 1) != 0) {
            n = n >> 1;
            cnt++;
        }
        cnt++;
        return 1 << cnt;
    }
}
