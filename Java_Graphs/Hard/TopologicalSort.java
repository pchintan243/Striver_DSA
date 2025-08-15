package Java_Graphs.Hard;
import java.util.List;
import java.util.Stack;

// This is stands for only DAG (Directed Acyclic Graph)
// There must be a cycle not exists
// If cycle exists then we can't able to convert into the Topological Sort
// For topological sort we are using DFS Traversal
public class TopologicalSort {
    void dfs(int v, List<List<Integer>> adj, boolean[] isVisited, Stack<Integer> st) {
        isVisited[v] = true;
        for(int i: adj.get(v)) {
            if(!isVisited[i]) {
                dfs(i, adj, isVisited, st);
            }
        }
        st.push(v);
    }
    public int[] topoSort(int V, List<List<Integer>> adj) {
        // Using DFS Topological Sort
        boolean[] isVisited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < V; i++) {
            if(!isVisited[i]) {
                dfs(i, adj, isVisited, st);
            }
        }
        int[] ans = new int[V];
        int ind = 0;
        while(!st.isEmpty()) {
            ans[ind++] = st.pop();
        }

        return ans;
    }
}