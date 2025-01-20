class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String firstString = strs[0];
        String lastString = strs[strs.length - 1];
        int len = firstString.length();
        int i = 0;
        while(i < len) {
            if(firstString.charAt(i) != lastString.charAt(i)) {
                return firstString.substring(0, i);
            }
            i++;
        }
        return "";
    }
}