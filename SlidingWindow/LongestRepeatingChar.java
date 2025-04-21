class LongestRepeatingChar {
    public int characterReplacement(String s, int k) {
        char[] ch = s.toCharArray();
        int[] mp = new int[26];
        int n = ch.length;
        int l = 0;
        int r = 0;
        int ans = 0;
        int maxFreq = 0;

        while(r < n) {

            mp[ch[r] - 'A']++;
            maxFreq = Math.max(maxFreq, mp[ch[r] - 'A']);

            if(r - l + 1 - maxFreq > k) {
                mp[ch[l] - 'A']--;
                l++;
            }

            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;
    }
}