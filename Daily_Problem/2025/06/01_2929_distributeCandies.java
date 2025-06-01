package Daily_Problem.2025.06;

class 01_2929_distributeCandies {
    public long distributeCandies(int n, int limit) {
        long ans = 0;
        int end = Math.min(limit, n);
        for(int i = 0; i <= end; i++) {
            if((n - i) <= 2 * limit) {
                ans += Math.min(n - i, limit) - Math.max(0, n - limit - i) + 1;
            }
        }
        return ans;
    }
}

