public class SpiralMatrix {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int cnt = 1;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        while(top < n && left < n) {

            for(int k = left; k <= right; k++) {
                ans[top][k] = cnt;
                cnt++;
            }

            top++;
            for(int k = top; k <= bottom; k++) {
                ans[k][right] = cnt;
                cnt++;
            }
            right--;

            for(int k = right; k >= left; k--) {
                ans[bottom][k] = cnt;
                cnt++;
            }
            bottom--;

            for(int k = bottom; k >= top; k--) {
                ans[k][left] = cnt;
                cnt++;
            }
            left++;
        }

        return ans;
    }
}