package Daily_Problem.2025.08;
import java.util.ArrayList;
import java.util.List;

public class 11_2438_ProductQueries {
    private static final int MOD = (int) 1e9 + 7;
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> powers = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            if ((n & (1 << i)) != 0) {
                powers.add(1 << i);
            }
        }

        int qLength = queries.length;

        int[] ans = new int[qLength];

        for(int i = 0; i < qLength; i++) {
            long temp = 1;
            for(int j = queries[i][0]; j <= queries[i][1]; j++) {
                temp = (temp * powers.get(j)) % MOD;
            }
            ans[i] = (int) temp;
        }
        return ans;
    }
}