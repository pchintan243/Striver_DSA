class AllDivisor {
    public static void print_divisors(int n) {
        // code here
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 1; (i * i) <= n; i++) {
            if((n % i) == 0) {
                ans.add(i);
                if((n / i) != i) {
                    ans.add(n / i);
                }
            }
        }
        Collections.sort(ans);
        for(int i : ans) {
            System.out.print(i + " ");
        }
    }
}