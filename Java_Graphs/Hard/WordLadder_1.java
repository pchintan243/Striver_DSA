package Java_Graphs.Hard;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder_1 {
  public int wordLadderLength(String startWord, String targetWord, List<String> wordList) {
    Set<String> wordSet = new HashSet<>(wordList);

    if (!wordSet.contains(targetWord)) {
      return 0;
    }
    Queue<String> q = new LinkedList<>();
    q.offer(startWord);

    Set<String> visited = new HashSet<>();
    visited.add(startWord);

    int ladderLength = 1;

    while (!q.isEmpty()) {
      int size = q.size();

      for(int i = 0; i < size; i++) {
        String currentWord = q.poll();

        if(currentWord.equals(targetWord)) {
          return ladderLength;
        }

        char[] wordArr = currentWord.toCharArray();
        for(int j = 0; j < wordArr.length; j++) {
          char originalChar = wordArr[j];

          for(char c = 'a'; c <= 'z'; c++) {
            if(wordArr[j] == c) {
              continue;
            }

            wordArr[j] = c;
            String newWord = new String(wordArr);
            if(wordSet.contains(newWord) && !visited.contains(newWord)) {
                q.offer(newWord);
                visited.add(newWord);
            }
          }
          wordArr[j] = originalChar;
        }
      }
      ladderLength++;
    }
    return 0;
  }
}
