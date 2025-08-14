package Java_Graphs.Medium;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        int orange = 0;

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] != 0) {
                    orange++;
                }
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        boolean[][] isVisited = new boolean[n][m];
        int cnt = 0;
        int[] delRow = {-1, 0, 0, 1};
        int[] delCol = {0, -1, 1, 0};
        int time = 0;

        while(!q.isEmpty()) {
            int qSize = q.size();
            cnt += qSize;
            while(qSize-- > 0) {
                int[] val = q.poll();
                int first = val[0];
                int second = val[1];

                for(int k = 0; k < 4; k++) {
                    int row = delRow[k] + first;
                    int col = delCol[k] + second;

                    if(row < 0 || row >= n || col < 0 || col >= m) {
                        continue;
                    }
                    if(grid[row][col] == 1 && !isVisited[row][col]) {
                        q.offer(new int[]{row, col});
                        isVisited[row][col] = true;
                    }
                }
            }
            if(!q.isEmpty()) 
                time++;
        }

        return cnt == orange ? time : -1;
    }
}


