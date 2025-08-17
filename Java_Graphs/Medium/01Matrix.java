package Java_Graphs.Medium;
import java.util.LinkedList;
import java.util.Queue;

public class 01Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];

        int[] delRow = new int[]{-1, 0, 0, 1};
        int[] delCol = new int[]{0, -1, 1, 0};
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                } else {
                    ans[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()) {
            int[] val = q.poll();
            int row = val[0];
            int col = val[1];

            for(int i = 0; i < 4; i++) {
                int first = row + delRow[i];
                int second = col + delCol[i];
                if(first < 0 || second < 0 || first >= n || second >= m) {
                    continue;
                }

                if(ans[first][second] == -1) {
                    ans[first][second] = ans[row][col] + 1;
                    q.offer(new int[]{first, second});
                }
            }
        }

        return ans;
    }
}