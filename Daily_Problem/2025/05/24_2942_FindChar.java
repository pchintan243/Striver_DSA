import java.util.ArrayList;
import java.util.List;
class 24_2942_FindChar {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < words.length; i++) {
            if(words[i].indexOf(x) != -1) {
                ans.add(i);
            }
        }

        return ans;
    }
}