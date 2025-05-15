import java.util.ArrayList;
import java.util.List;
class 15_2900_LongestADJ {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        int last = groups[0];
        for(int i = 1; i < groups.length; i++) {
            if(groups[i] != last) {
                ans.add(words[i]);
                last = groups[i];
            }
        }

        return ans;
    }
}