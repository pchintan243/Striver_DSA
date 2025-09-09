package Java_Graphs.AdditionalAlgorithm;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KosarajusAlgo {
    /* Function to perform DFS for storing the 
    nodes in stack based on their finishing time */
    private void dfs(int u, ArrayList<ArrayList<Integer>> adj, boolean[] isVisited, Stack<Integer> st) {
        isVisited[u] = true;

        for(int v: adj.get(u)) {
            if(!isVisited[v]) {
                dfs(v, adj, isVisited, st);
            }
        }
        st.push(u);
    }

    /* Helper function to perform DFS for finding
    number of Strongly connected components */
    private void reverseEdgeDFS(int u, List<List<Integer>> adj, boolean[] isVisited) {
        isVisited[u] = true;

        for(int v: adj.get(u)) {
            if(!isVisited[v]) {
                reverseEdgeDFS(v, adj, isVisited);
            }
        }
    }

    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] isVisited = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < V; i++) {
            if(!isVisited[i]) {
                dfs(i, adj, isVisited, st);
            }
        }

        isVisited = new boolean[V];

        List<List<Integer>> reverse = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            reverse.add(new ArrayList<>());
        }
        for(int i = 0; i < V; i++) {
            for(Integer v: adj.get(i)) {
                reverse.get(v).add(i);
            }
        }

        int cnt = 0;
        while(!st.isEmpty()) {
            int u = st.pop();
            if(!isVisited[u]) {
                reverseEdgeDFS(u, reverse, isVisited);
                cnt++;
            }
        }
        return cnt;
    }
}


// Time Complexity:O(V + E) due to DFS traversals, where V is the number of vertices and E is the number of edges.
// Space Complexity:O(V) due to the stack, visited array, and recursion depth.