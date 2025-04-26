class MinWindowSubStr {
    public String minWindow(String s, String t) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int[] dp = new int[256];
        int ans = Integer.MAX_VALUE;
        String res = "";

        for(char c : t.toCharArray()) {
            dp[c]++;
        }

        
        int cnt = 0;
        int l = 0;
        int r = 0;
        int m = t.length();

        while(r < n) {
            dp[ch[r]]--;
            if(dp[ch[r]] >= 0) {
                cnt++;
            }

            while(cnt == m) {

                int len = r - l + 1;
                if(ans > len) {
                    ans = len;
                    res = s.substring(l, r + 1);
                }
                dp[ch[l]]++;
                if(dp[ch[l++]] > 0) {
                    cnt--;
                }
            }

            r++;
        }
        return res;
    }

}