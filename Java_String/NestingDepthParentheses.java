class Solution {
    public int maxDepth(String s) {
        int cnt = 0;
        int ans = -1;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                cnt++;
                ans = Math.max(ans, cnt);
            } else if(c == ')') {
                cnt--;
            }
            
        }
        return ans;
    }
}