package Java_Graphs.Medium;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfTheNearestCell {
    public int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        int[][] ans = new int[n][m];


        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    q.offer(new int[]{i, j, 0});
                }
            }
        }

        boolean[][] isVisited = new boolean[n][m];
        int[] delRow = {-1, 0, 0, 1};
        int[] delCol = {0, -1, 1, 0};

        while(!q.isEmpty()) {
            int[] val = q.poll();
            int first = val[0];
            int second = val[1];
            int distance = val[2];

            for(int k = 0; k < 4; k++) {
                int row = delRow[k] + first;
                int col = delCol[k] + second;

                if(row < 0 || row >= n || col < 0 || col >= m) {
                    continue;
                }
                if(grid[row][col] == 0 && !isVisited[row][col]) {
                    q.offer(new int[]{row, col, distance + 1});
                    ans[row][col] = distance + 1;
                    isVisited[row][col] = true;
                }
            }
        }
        return ans;
    }
}