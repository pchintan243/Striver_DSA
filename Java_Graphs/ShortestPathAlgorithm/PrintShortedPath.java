package Java_Graphs.ShortestPathAlgorithm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintShortedPath {
    public List<Integer> shortestPath(int n, int m, int[][] edges) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;
        pq.offer(new int[]{0, 0});
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            int u = edges[i][0] - 1;
            int v = edges[i][1] - 1;
            int w = edges[i][2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }
        
        int[] cameFrom = new int[n];
        while(!pq.isEmpty()) {
            int[] val = pq.poll();
            int dist = val[0];
            int u = val[1];

            for(int[] data: adj.get(u)) {
                int v = data[0];
                int weight = data[1];
                if(dist + weight < ans[v]) {
                    ans[v] = dist + weight;
                    pq.offer(new int[]{ans[v], v});
                    cameFrom[v] = u;
                }
            }
        }
        if(ans[n - 1] == Integer.MAX_VALUE) {
            return List.of(-1);
        }

        List<Integer> path = new ArrayList<>();
        int temp = n - 1;
        path.add(n);

        while(temp != 0) {
            int node = cameFrom[temp];
            path.add(node + 1);
            temp = node;
        }
        path.add(ans[n - 1]);

        Collections.reverse(path);
        
        return path;
    }
}