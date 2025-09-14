package Daily_Problem.2025.09;
import java.util.HashMap;
import java.util.Map;

class 14_966_SpellChecker {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactWords = new HashSet<>();
        Map<String, String> caseMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();
        boolean[] isVowel = new boolean[128];
        for(char c: "aeiouAEIOU".toCharArray()) {
            isVowel[c] = true;
        }
        for(String s: wordlist) {
            exactWords.add(s);
            String l = s.toLowerCase();
            if(!caseMap.containsKey(l)) {
                caseMap.put(l, s);
            }
            char[] ch = l.toCharArray();
            for(int i = 0; i < l.length(); i++) {
                if(isVowel[ch[i]]) {
                    ch[i] = '*';
                }
            }
            String newString = new String(ch);

            if(!vowelMap.containsKey(newString)) {
                vowelMap.put(newString, s);
            }
        }
        String[] ans = new String[queries.length];
        int ind = 0;
        for(String q: queries) {
            String ll = q.toLowerCase();
            if(exactWords.contains(q)) {
                ans[ind++] = q;
            } else if(caseMap.containsKey(ll)) {
                ans[ind++] = caseMap.get(ll);
            } else {
                char[] ch = ll.toCharArray();
                for(int i = 0; i < ll.length(); i++) {
                    if(isVowel[ch[i]]) {
                        ch[i] = '*';
                    }
                }
                String newString = new String(ch);

                if(vowelMap.containsKey(newString)) {
                    ans[ind++] = vowelMap.get(newString);
                } else {
                    ans[ind++] = "";
                }
            }
        }
        return ans;
    }
}