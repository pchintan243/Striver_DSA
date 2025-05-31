import java.util.Arrays;
class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        int sn = s.length;
        int gn = g.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int ind = 0;
        for(int i = 0; i < sn; i++) {
            if(s[i] >= g[ind]) {
                ans++;
                ind++;
            }
            if(ind == gn) {
                break;
            }
        }
        return ans;
    }
}