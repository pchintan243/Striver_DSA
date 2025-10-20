package Matrix.Medium;

public class 378_KSmallestElement {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int cnt = findLowerNumberCnt(mid, matrix);

            if(cnt < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private int findLowerNumberCnt(int mid, int[][] matrix) {
        int cnt = 0;
        int n = matrix.length;
        int i = n - 1;
        int j = 0;
        while(i >= 0 && j < n) {
            if(matrix[i][j] <= mid) {
                cnt += i + 1;
                j++;
            } else {
                i--;
            }
        }

        return cnt;
    }
}