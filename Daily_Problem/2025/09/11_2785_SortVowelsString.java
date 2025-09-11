package Daily_Problem.2025.09;
import java.util.Arrays;

public class 11_2785_SortVowelsString {
    public String sortVowels(String s) {
        StringBuilder sb = new StringBuilder();

        boolean[] isVowel = new boolean[128];
        for (char c : "aeiouAEIOU".toCharArray()) {
            isVowel[c] = true;
        }
        
        for(char c: s.toCharArray()) {
            if(isVowel[c]) {
                sb.append(c);
            }
        }

        if(sb.isEmpty()) {
            return s;
        }
        char[] ch = sb.toString().toCharArray();
        Arrays.sort(ch);
        sb = new StringBuilder(s);
        for(int i = 0, ind = 0; i < s.length(); i++) {
            if(isVowel[s.charAt(i)]) {
                sb.setCharAt(i, ch[ind++]);
            }
        }

        return sb.toString();
    }
}