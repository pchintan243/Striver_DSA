package Java_Graphs.Hard;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
  public String findOrder(String[] dict, int N, int K) {
    int[] inDegree = new int[K];
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < K; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < N - 1; i++) {
      String s1 = dict[i];
      String s2 = dict[i + 1];
      int len = Math.min(s1.length(), s2.length());

      /* Compare the pair of strings letter by
      letter to identify the differentiating letter */
      for (int ptr = 0; ptr < len; ptr++) {

        // If the differentiating letter is found
        if (s1.charAt(ptr) != s2.charAt(ptr)) {
          adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
          inDegree[s2.charAt(ptr) - 'a']++;
          break;
        }
      }
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < K; i++) {
      if (inDegree[i] == 0) {
        q.offer(i);
      }
    }

    StringBuilder sb = new StringBuilder();
    while (!q.isEmpty()) {
      int u = q.poll();
      sb.append((char) (u + 'a'));
      for (int v : adj.get(u)) {
        inDegree[v]--;
        if (inDegree[v] == 0) {
          q.offer(v);
        }
      }
    }
    return sb.length() == K ? sb.toString() : "";
  }
}
