package Daily_Problem.2025.10;
import java.util.ArrayList;
import java.util.List;

public class 13_2273_CheckAnagrams {
    public List<String> removeAnagrams(String[] words) {
        List<String> lst = new ArrayList<>();
        int n = words.length;
        lst.add(words[0]);
        for(int i = 1; i < n; i++) {
            if(!isAnagram(words[i - 1], words[i])) {
                lst.add(words[i]);
            }
        }
        return lst;
    }

    private boolean isAnagram(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if(n != m) {
            return false;
        }
        int[] cnt = new int[26];
        for(int i = 0; i < n; i++) {
            cnt[word1.charAt(i) - 'a']++;
            cnt[word2.charAt(i) - 'a']--;
        }

        for(int i: cnt) {
            if(i != 0) {
                return false;
            }
        }

        return true;
    }
}