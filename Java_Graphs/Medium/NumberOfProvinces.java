package Java_Graphs.Medium;
import java.util.ArrayList;
import java.util.List;

// It's same as Connected Components
public class NumberOfProvinces {
    void dfs(int ind, List<List<Integer>> adj, boolean[] isVisited) {
        isVisited[ind] = true;
        for(int i: adj.get(ind)) {
            if(!isVisited[i]) {
                dfs(i, adj, isVisited);
            }
        }
    }
    public int numProvinces(int[][] adj) {
        int componentCnt = 0;
        int n = adj.length;

        List<List<Integer>> mat = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            mat.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(adj[i][j] == 1 && i != j) {
                    mat.get(i).add(j);
                }
            }
        }
        boolean[] isVisited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!isVisited[i]) {
                componentCnt++;
                dfs(i, mat, isVisited);
            }
        }
        return componentCnt;
    }
}

