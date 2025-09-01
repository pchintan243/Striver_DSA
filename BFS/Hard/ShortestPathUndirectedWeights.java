package BFS.Hard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathUndirectedWeights {
    public int[] shortestPath(int[][] edges, int N, int M) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] ans = new int[N];
        Arrays.fill(ans, -1);
        ans[0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        boolean[] isVisited = new boolean[N];
        isVisited[0] = true;
        while(!q.isEmpty()) {
            int[] val = q.poll();
            int u = val[0];
            int steps = val[1];
            for(int v: adj.get(u)) {
                if(!isVisited[v]) {
                    isVisited[v] = true;
                    ans[v] = steps + 1;
                    q.offer(new int[]{v, steps + 1});
                }
            }
        }

        return ans;
    }
}
