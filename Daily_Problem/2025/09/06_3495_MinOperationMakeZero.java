package Daily_Problem.2025.09;

public class 06_3495_MinOperationMakeZero {
    long makeZero(int num) {
        long ans = 0;
        int base = 1;
        int i = 1;
        while(base <= num) {
            int end = Math.min(num, 2 * base - 1);
            ans += (long) ((i + 1) / 2) * (end - base + 1);
            base *= 2;
            i++;
        }
        return ans;
    }
    public long minOperations(int[][] queries) {
        long ans = 0;
        int n = queries.length;
        for(int i = 0; i < n; i++) {
            long second = makeZero(queries[i][1]);
            long first = makeZero(queries[i][0] - 1);

            ans += (second - first + 1) / 2;
        }

        return ans;
    }
}