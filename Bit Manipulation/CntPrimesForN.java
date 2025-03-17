class CntPrimesForN {
    public int countPrimes(int n) {
        int cnt = 0;
        if(n <= 1) {
            return cnt;
        }
        if(n == 2) {
            return 1;
        }

        int[] prime = new int[n + 1];
        Arrays.fill(prime, 1);
        prime[0] = 0;
        prime[1] = 0;
        for(int i = 2; (i * i) <= n; i++) {
            if(prime[i] == 1) {
                for(int j = (i * i); j <= n; j += i) {
                    prime[j] = 0;
                }
            }
        }

        for(int i : prime) {
            if(i == 1)
                cnt++;
        }
        return cnt;

    }
}