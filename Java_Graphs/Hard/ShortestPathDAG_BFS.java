package Java_Graphs.Hard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathDAG_BFS {
  public int[] shortestPath(int N, int M, int[][] edges) {
    int[] inDegree = new int[N];

    List<List<int[]>> adj = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      adj.get(edges[i][0]).add(new int[]{edges[i][1], edges[i][2]});
      inDegree[edges[i][1]]++;
    }

    Queue<Integer> q = new LinkedList<>();

    int[] ans = new int[N];
    int[] topo = new int[N];
    Arrays.fill(ans, Integer.MAX_VALUE);
    for (int i = 0; i < N; i++) {
      if (inDegree[i] == 0) {
        q.offer(i);
      }
    }
    int ind = 0;
    while (!q.isEmpty()) {
      int u = q.poll();
      topo[ind++] = u;
      for (int[] v : adj.get(u)) {
        int nextNode = v[0];
        inDegree[nextNode]--;
        if (inDegree[nextNode] == 0) {
          q.offer(nextNode);
        }
      }
    }

    ans[0] = 0;
    for(int i = 0; i < N; i++) {
      if (ans[topo[i]] != Integer.MAX_VALUE) {
        for(int[] v: adj.get(topo[i])) {
          ans[v[0]] = Math.min(ans[v[0]], ans[topo[i]] + v[1]);
        }
      }
    }

    for (int i = 1; i < N; i++) {
      if(ans[i] == Integer.MAX_VALUE) {
        ans[i] = -1;
      }
    }
    return ans;
  }
}
