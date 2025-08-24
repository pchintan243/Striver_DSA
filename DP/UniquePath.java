public class UniquePath {
    public int uniquePaths(int m, int n) {
        int total = m + n - 2;
        int choose = m - 1;
        
        if (choose < 0 || choose > total) {
            return 0;
        }
        if (choose == 0 || choose == total) {
            return 1;
        }
        // Tame advantage of the symmetry C(ntotal, choose) = C(total, total-choose)
        if (choose > total / 2) {
            choose = total - choose;
        }

        long result = 1;
        for (int i = 1; i <= choose; ++i) {
            result = result * (total - i + 1) / i;
        }
        result = result <= 2 * (int) 1e9 ? result : (result % (int) 1e9);
        return Integer.parseInt(result + "");
    }
}