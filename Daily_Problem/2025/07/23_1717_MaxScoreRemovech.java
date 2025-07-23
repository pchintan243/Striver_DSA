public class 23_1717_MaxScoreRemovech {
    public int maximumGain(String s, int x, int y) {
        char[] ch = s.toCharArray();
        int n = s.length();
        int ans = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        char ch1 = 'a';
        char ch2 = 'b';
        if(x < y) {
            int temp = x;
            x = y;
            y = temp;
            ch1 = 'b';
            ch2 = 'a';
        }
        for(int i = 0; i < n; i++) {
            if(ch[i] == ch1) {
                cnt1++;
            } else if(ch[i] == ch2) {
                if(cnt1 > 0) {
                    cnt1--;
                    ans += x;
                } else {
                    cnt2++;
                }
            } else {
                ans += Math.min(cnt1, cnt2) * y;
                cnt1 = 0;
                cnt2 = 0;
            }
        }

        if(cnt1 != 0) {
            ans += Math.min(cnt1, cnt2) * y;
        }

        return ans;
    }
}