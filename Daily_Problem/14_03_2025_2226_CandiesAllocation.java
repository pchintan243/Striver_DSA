class 14_03_2025_2226_CandiesAllocation {
    public boolean distributeCandies(int[] candies, long k, int mid) {
        long childCnt = 0;
        for(int j = candies.length - 1; j >= 0 ; j--) {
            childCnt += (candies[j] / mid);
            if(childCnt >= k) {
                return true;
            }
        }
        return false;
    }
    public int maximumCandies(int[] candies, long k) {
        Arrays.sort(candies);
        int ans = 0;
        int low = 1;
        int high = Arrays.stream(candies).max().orElse(Integer.MIN_VALUE);
        while(low <= high) {
            int mid = (low + high) / 2;
            if(distributeCandies(candies, k, mid)) {
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}