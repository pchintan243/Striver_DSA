package Daily_Problem.2025.12;

public class 28_1351_CntNegativeNum {
    private int binarySearch(int[] mat, int n) {
        int low = 0;
        int high = n - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(mat[mid] < 0) {
                high--;
            } else {
                low++;
            }
        }

        return n - low;
    }
    public int countNegatives(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < n; i++) {
            ans += binarySearch(grid[i], m);
        }

        return ans;
    }
}