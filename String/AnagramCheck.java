class Solution {
    public boolean isAnagram(String s, String t) {
        char[] cst = s.toCharArray();
        java.util.Arrays.sort(cst);

        char[] cts = t.toCharArray();
        java.util.Arrays.sort(cts); 

        if(Arrays.equals(cst, cts))
            return true;
        return false;
    }
}