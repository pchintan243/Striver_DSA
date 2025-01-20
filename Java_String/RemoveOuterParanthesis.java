class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int cnt = 0;
        if (len <= 2) return "";
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                cnt++;
            } else {
                cnt--;
            }
            if(cnt > 1) {
                ans.append(s.charAt(i));
            } else if(cnt > 0 && s.charAt(i) == ')')  {
                ans.append(')');
            }
        }
        return ans.toString();
    }
}