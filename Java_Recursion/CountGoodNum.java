class CountGoodNum {
    public long MOD = 1_000_000_007;
    
    public long findPow(int x, long n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        long ans = findPow(x, n / 2);
        if(n % 2 == 0) 
            ans = (ans * ans) % MOD;
        else
            ans = (ans * ans * x) % MOD;
        return ans;
        
    }
    public int countGoodNumbers(long n) {
        if(n == 1) {
            return 5;
        }

        return (int)(findPow(5, (n + 1) / 2) * findPow(4, n / 2) % MOD);
    }
}