package Daily_Problem.2025.11;

public class 14_2536_IncrementSubMatrix {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] ans = new int[n][n];

        for(int[] q: queries) {
            for(int i = q[0]; i <= q[2]; i++) {
                for(int j = q[1]; j <= q[3]; j++) {
                    ans[i][j]++;
                }
            }
        }

        return ans;
    }
}