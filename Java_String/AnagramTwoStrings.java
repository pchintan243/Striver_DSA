class Solution {
    public boolean isAnagram(String s, String t) {
        char[] cst = s.toCharArray();        // convert to array of chars 
        java.util.Arrays.sort(cst); 
        String newString1 = new String(cst);

        char[] cts = t.toCharArray();        // convert to array of chars 
        java.util.Arrays.sort(cts); 
        String newString2 = new String(cts);

        if(Arrays.equals(cst, cts))
            return true;
        return false;
    }
}