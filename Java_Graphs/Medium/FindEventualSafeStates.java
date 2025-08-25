package Java_Graphs.Medium;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[n];
        for(int i = 0; i < n; i++) {
            for(int u: graph[i]) {
                adj.get(u).add(i);
                inDegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }
        while(!q.isEmpty()) {
            int v = q.poll();
            ans.add(v);
            for(int vv: adj.get(v)) {
                inDegree[vv]--;
                if(inDegree[vv] == 0) {
                    q.offer(vv);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}