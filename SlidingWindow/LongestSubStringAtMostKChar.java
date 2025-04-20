package SlidingWindow;
import java.util.HashMap;
import java.util.Map;

class LongestSubStringAtMostKChar {
    public int kDistinctChar(String s, int k) {
        //your code goes here
        Map<Character, Integer> mp = new HashMap<>();

        char[] ch = s.toCharArray();
        int n = ch.length;
        int l = 0;
        int r = 0;
        int ans = 0;

        while(r < n) {
            mp.put(ch[r], mp.getOrDefault(ch[r], 0) + 1);

            if(mp.size() > k) {
                if(mp.get(ch[l]) == 1) {
                    mp.remove(ch[l]);
                } else {
                    mp.put(ch[l], mp.get(ch[l]) - 1);
                }
                l++;
            }

            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;

    }
}