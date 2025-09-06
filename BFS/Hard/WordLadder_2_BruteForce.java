package BFS.Hard;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder_2_BruteForce {
       public List<List<String>> findSequences(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> ans = new ArrayList<>();
        Queue<List<String>> q = new LinkedList<>();
        q.offer(new ArrayList<>(List.of(beginWord)));

        Set<String> st = new HashSet<>(wordList);
        st.remove(beginWord);

        Set<String> visited = new HashSet<>();

        while(!q.isEmpty()) {
            int n = q.size();
            for(int i = 0; i < n; i++) {
                List<String> lst = q.poll();

                String word = lst.get(lst.size() - 1);
                if(word.equals(endWord)) {
                    ans.add(new ArrayList<>(lst));
                }

                for(int pos = 0; pos < word.length(); pos++) {
                    char originalChar = word.charAt(pos);

                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        char[] wordArray = word.toCharArray();

                        wordArray[pos] = ch;
                        String newWord = new String(wordArray);

                        if(st.contains(newWord)) {
                            lst.add(newWord);
                            q.add(new ArrayList<>(lst));
                            visited.add(newWord);
                            lst.remove(lst.size() - 1);
                        }
                    }

                    String beforePos = word.substring(0, pos);
                    String afterPos = word.substring(pos + 1);
                    word = beforePos + originalChar + afterPos;
                }
            }
            if(!ans.isEmpty()) {
                break;
            }

            for(String it: visited) {
                st.remove(it);
            }
            visited.clear();

        }
        return ans;
    }
}
