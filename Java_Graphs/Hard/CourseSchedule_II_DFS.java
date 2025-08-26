package Java_Graphs.Hard;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseSchedule_II_DFS {
  Stack<Integer> st;
  boolean dfs(int u, boolean[] pathVisited, boolean[] isVisited, List<List<Integer>> adj) {
    pathVisited[u] = true;
    isVisited[u] = true;
    for(int v: adj.get(u)) {
      if(pathVisited[v]) {
        return false;
      }
      if(!isVisited[v] && !dfs(v, pathVisited, isVisited, adj)) {
        return false;
      }
    }
    st.push(u);
    pathVisited[u] = false;
    return true;
  }
  public int[] findOrder(int N, int[][] arr) {
    boolean[] isVisited = new boolean[N];
    boolean[] pathVisited = new boolean[N];
    st = new Stack<>();
    List<List<Integer>> adj = new ArrayList<>();

    for(int i = 0; i < N; i++) {
      adj.add(new ArrayList<>());
    }

    for(int i = 0; i < arr.length; i++) {
      adj.get(arr[i][1]).add(arr[i][0]);
    }
    for(int i = 0; i < N; i++) {
      if(!isVisited[i]) {
        if(!dfs(i, pathVisited, isVisited, adj)) {
          return new int[]{};
        }
      }
    }
    if(st.size() == N) {
      int ind = 0;
      int[] ans = new int[N];
      while(!st.isEmpty()) {
        ans[ind++] = st.pop();
      }
      return ans;
    }
    return new int[]{};
  }
}
