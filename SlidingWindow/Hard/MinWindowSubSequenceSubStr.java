class MinWindowSubSequenceSubStr {
    static String minWindow(String s1, String s2) {
        // code here
        char[] ch = s1.toCharArray();
        int n = s1.length();
        int r = 0;
        int cnt = 0;
        int ans = Integer.MAX_VALUE;
        String res = "";
        char[] chs = s2.toCharArray();
        
        
        while(r < n) {
            
            if(chs[cnt] == ch[r]) {
                cnt++;
            }
            
            if(cnt == s2.length()) {
                int i = r;
                cnt--;
                
                while(i >= 0 && cnt >= 0) {
                    if(ch[i] == chs[cnt])
                        cnt--;
                    i--;
                }
                i++;
                int len = r - i + 1;
                if(ans > len) {
                    ans = len;
                    res = s1.substring(i, r + 1);
                }
                cnt = 0;
                r = i + 1;
            }
            r++;
        }
        return res;
    }
}
