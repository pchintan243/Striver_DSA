package Java_Graphs.ShortestPathAlgorithm;
import java.util.ArrayList;
import java.util.Arrays;

public class Dijkstra_Set {
  public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {

    int[] ans = new int[V];
    Arrays.fill(ans, Integer.MAX_VALUE);
    ans[S] = 0;

    TreeSet<int[]> st = new TreeSet<>((a, b) -> {
        if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
    });
    st.add(new int[]{0, S});

    while(!st.isEmpty()) {
        int[] val = st.pollFirst();
        int u = val[1];
        int distance = val[0];
        for(ArrayList<Integer> data: adj.get(u)) {
            int v = data.get(0);
            int weight = data.get(1);
            if(ans[v] > distance + weight) {
                st.remove(new int[]{ans[v], u});
                ans[v] = distance + weight;
                st.add(new int[]{ans[v], v});
            }
        }
    }
    for(int i = 0; i < V; i++) {
        if(ans[i] == Integer.MAX_VALUE) {
            ans[i] = 1000000000;
        }
    }
    return ans;
  }
}
