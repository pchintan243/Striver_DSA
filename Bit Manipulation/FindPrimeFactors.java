class FindPrimeFactors {
    // You must implement this function
    static void sieve() {}

    static List<Integer> findPrimeFactors(int N) {
        // code here
        List<Integer> ans = new ArrayList<>();
        int num = N;
        for(int i = 2; (i * i) <= N; ) {
            if(num % i == 0) {
                ans.add(i);
                num /= i;
            } else {
                i++;
            }
        }
        if(num != 1) {
            ans.add(num);
        }
        
        return ans;
        
    }
}
