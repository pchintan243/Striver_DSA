import java.util.Arrays;
class LongestSubStringWIthoutRepeatingChar {
    public int lengthOfLongestSubstring(String s) {
        char[] c = s.toCharArray();
        int ans = 0;
        int[] mp = new int[256];
        int l = 0;
        int r = 0;
        Arrays.fill(mp, -1);
        while(r < c.length) {
            if(mp[c[r]] != -1 && mp[c[r]] >= l) {
                l = mp[c[r]] + 1;
            }
            mp[c[r]] = r;
            ans = Math.max(r - l + 1, ans);
            r++;
        }

        return ans;
    }
}