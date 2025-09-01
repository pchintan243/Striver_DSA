package BFS.Hard;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WordLadder_1 {
  public int wordLadderLength(String startWord, String targetWord, List<String> wordList) {
    if(startWord.equals(targetWord) && wordList.contains(targetWord)) {
      return 1;
    }
    if (!wordList.contains(targetWord)) {
      return 0;
    }

    Map<String, List<String>> adj = new HashMap<>();
    int n = wordList.size();

    adj.putIfAbsent(startWord, new ArrayList<>());
    for (int i = 0; i < n; i++) {
      if (wordList.get(i).equals(startWord)) {
        continue;
      }
      int cnt = 0;
      int ind = 0;
      char[] c = startWord.toCharArray();
      for (char ch : wordList.get(i).toCharArray()) {
        if (ch != c[ind]) {
          cnt++;
        }
        if (cnt == 2) {
          break;
        }
        ind++;
      }
      if (cnt == 1) {
        adj.putIfAbsent(wordList.get(i), new ArrayList<>());
        adj.get(startWord).add(wordList.get(i));
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (wordList.get(i).equals(wordList.get(j))) {
          continue;
        }
        if (adj.containsKey(wordList.get(i))) {
          List<String> st = adj.get(wordList.get(i));
          if (st.contains(wordList.get(j))) {
            continue;
          }
        }
        int cnt = 0;
        int ind = 0;
        char[] c = wordList.get(j).toCharArray();
        for (char ch : wordList.get(i).toCharArray()) {
          if (ch != c[ind]) {
            cnt++;
          }
          if (cnt == 2) {
            break;
          }
          ind++;
        }
        if (cnt == 1) {
          adj.putIfAbsent(wordList.get(i), new ArrayList<>());
          adj.putIfAbsent(wordList.get(j), new ArrayList<>());
          adj.get(wordList.get(i)).add(wordList.get(j));
          adj.get(wordList.get(j)).add(wordList.get(i));
        }
      }
    }

    Queue<String[]> q = new LinkedList<>();

    q.offer(new String[] {startWord, "1"});
    Set<String> st = new HashSet<>();
    st.add(startWord);
    while (!q.isEmpty()) {
      String[] val = q.poll();
      String u = val[0];
      int steps = Integer.parseInt(val[1]);

      for (String v : adj.get(u)) {
        if (v.equals(targetWord)) {
          return steps + 1;
        }
        if (!st.contains(v)) {
          q.offer(new String[] {v, steps + 1 + ""});
          st.add(v);
        }
      }
    }
    return 0;
  }
}
