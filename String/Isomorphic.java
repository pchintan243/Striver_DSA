class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> st = new HashMap<>();
        Map<Character, Integer> ts = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            if(!st.containsKey(s.charAt(i))) {
                st.put(s.charAt(i), i);
            }
            if(!ts.containsKey(t.charAt(i))) {
                ts.put(t.charAt(i), i);
            }
            // check if one char is not mapped with more than one char
            if(!st.get(s.charAt(i)).equals(ts.get(t.charAt(i))))
                return false;
        }

        return true;
    }
}