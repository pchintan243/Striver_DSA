class PrimeFactorUsingSieve {
    // You must implement this function
    static void sieve() {}

    static List<Integer> findPrimeFactors(int n) {
        // code here
        List<Integer> ans = new ArrayList<>();
        
        int[] prime = new int[n + 1];
        for(int i = 2; i <= n; i++) {
            prime[i] = i;
        }
        
        for(int i = 2; (i * i) <= n; i++) {
            if(prime[i] == i) {
                for(int j = (i * i); j <= n; j += i) {
                    if(prime[j] == j)
                        prime[j] = i;
                }
            }
        }
        int num = n;
        while (num != 1) {
            ans.add(prime[num]);
            num = num / prime[num];
        }
                
        return ans;
        
    }
}