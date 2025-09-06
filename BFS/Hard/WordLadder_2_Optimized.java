package BFS.Hard;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WordLadder_2_Optimized {
    public List<List<String>> findSequences(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();

        Map<String, Integer> mp = new HashMap<>();
        mp.put(beginWord, 0);

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        Set<String> st = new HashSet<>(wordList);
        st.remove(beginWord);

        while (!q.isEmpty()) {
            String word = q.poll();
            if(word.equals(endWord)) {
                break;
            }
            int steps = mp.get(word);

            char[] ch = word.toCharArray();
            for (int pos = 0; pos < word.length(); pos++) {
                char originalChar = ch[pos];
                for (char c = 'a'; c <= 'z'; c++) {
                    ch[pos] = c;
                    String w = new String(ch);
                    if (st.contains(w)) {
                        q.offer(w);
                        mp.put(w, steps + 1);
                        st.remove(w);
                    }
                }
                ch[pos] = originalChar;
            }
        }
        if (!mp.isEmpty() && mp.containsKey(endWord)) {
            List<String> lst = new ArrayList<>(List.of(endWord));
            dfs(beginWord, endWord, lst, ans, mp);
        }
        return ans;
    }

    void dfs(String src, String target, List<String> lst, List<List<String>> ans, Map<String, Integer> mp) {
        if(src.equals(target)) {
            Collections.reverse(lst);
            ans.add(new ArrayList<>(lst));
            Collections.reverse(lst);
            return;
        }
        int steps = mp.get(target);

        char[] ch = target.toCharArray();
        for (int pos = 0; pos < target.length(); pos++) {
            char originalChar = ch[pos];
            for (char c = 'a'; c <= 'z'; c++) {
                ch[pos] = c;
                String w = new String(ch);
                if (mp.containsKey(w) && mp.get(w) == steps - 1) {
                    lst.add(w);
                    dfs(src, w, lst, ans, mp);
                    lst.remove(lst.size() - 1);
                }
            }
            ch[pos] = originalChar;
        }
    }
}
