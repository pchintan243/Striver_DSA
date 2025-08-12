package Java_Graphs.Medium;
import java.util.ArrayList;
import java.util.List;

class TraversalTechnique {
  public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
    List<Integer> ans = new ArrayList<>();
    boolean[] isVisited = new boolean[V];
    dfs(0, adj, isVisited, ans);
    return ans;
  }

  private void dfs(int ind, List<List<Integer>> adj, boolean[] isVisited, List<Integer> ans) {
    isVisited[ind] = true;
    ans.add(ind);

    for (int neighbor : adj.get(ind)) {
      if (!isVisited[neighbor]) {
        dfs(neighbor, adj, isVisited, ans);
      }
    }
  }

  public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
    List<Integer> ans = new ArrayList<>();
    boolean[] isVisited = new boolean[V];

    isVisited[0] = true;
    Queue<Integer> q = new LinkedList<>();
    q.offer(0);

    while (!q.isEmpty()) {
      int currentNode = q.poll();
      ans.add(currentNode);
      for (int tt : adj.get(currentNode)) {
        if (!isVisited[tt]) {
          isVisited[tt] = true;
          q.offer(tt);
        }
      }
    }

    return ans;
  }
}
