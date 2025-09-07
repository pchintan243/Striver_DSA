package Java_Graphs.ShortestPathAlgorithm;
import java.util.Arrays;
import java.util.List;

public class PathMinEffort {
    public int MinimumEffort(List<List<Integer>> heights) {
        int[] delRow = new int[]{-1, 0, 0, 1};
        int[] delCol = new int[]{0, -1, 1, 0};
        int n = heights.size();
        int m = heights.get(0).size();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );
        pq.offer(new int[]{0, 0, 0});

        int[][] distance = new int[n][m];
        for(int[] i: distance) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        distance[0][0] = 0;

        while(!pq.isEmpty()) {
            int[] val = pq.poll();
            int dist = val[0];
            int row = val[1];
            int col = val[2];
            if(row == n - 1 && col == m - 1) {
                return dist;
            }

            for(int i = 0; i < 4; i++) {
                int r = row + delRow[i];
                int c = col + delCol[i];
                if(r >= 0 && c >= 0 && r < n && c < m) {
                    int diff = Math.max(Math.abs(heights.get(r).get(c) - heights.get(row).get(col)), dist);

                    if(distance[r][c] > diff) {
                        distance[r][c] = diff;
                        pq.offer(new int[]{diff, r, c});
                    }
                }
            }
        }
        return distance[n - 1][m - 1];
    }
}
