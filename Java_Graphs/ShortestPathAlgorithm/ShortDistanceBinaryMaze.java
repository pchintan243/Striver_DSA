package Java_Graphs.ShortestPathAlgorithm;
import java.util.Arrays;

public class ShortDistanceBinaryMaze {
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        // Edge Case
        if (source[0] == destination[0] && source[1] == destination[1])
            return 0;
        int[] delRow = new int[]{-1, 0, 0, 1};
        int[] delCol = new int[]{0, -1, 1, 0};
        int n = grid.length;
        int m = grid[0].length;

        int length = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );
        pq.offer(new int[]{0, source[0], source[1]});

        int[][] distance = new int[n][m];
        for(int[] i: distance) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        distance[source[0]][source[1]] = 0;
        int destRow = destination[0];
        int destCol = destination[1];

        while(!pq.isEmpty()) {
            int[] val = pq.poll();
            int dist = val[0];
            int row = val[1];
            int col = val[2];
            if(row == destRow && col == destCol) {
                return dist;
            }
            for(int i = 0; i < 4; i++) {
                int r = row + delRow[i];
                int c = col + delCol[i];
                if(r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1) {
                    if(distance[r][c] > dist + 1) {
                        distance[r][c] = dist + 1;
                        pq.offer(new int[]{dist + 1, r, c});
                    }
                }
            }
        }
        return -1;
    }
}

