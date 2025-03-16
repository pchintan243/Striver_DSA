class AllPrimeFactorOfN
{
    public int[] AllPrimeFactors(int n)
    {
        // code here
        if(n < 2) {
            return new int[]{};
        }
        Set<Integer> ans = new HashSet<>();
        int num = n;
        for(int i = 2; (i * i) <= n; i++) {
            while(num % i == 0) {
                ans.add(i);
                num = num / i;
            }
        }
        if(num != 1) {
            ans.add(num);
        }
        int[] sortAns = ans.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(sortAns);
        return sortAns;
    }
