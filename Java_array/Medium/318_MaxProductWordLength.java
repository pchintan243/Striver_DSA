package Medium;

public class 318_MaxProductWordLength {
    public int maxProduct(String[] words) {
        int ans = 0;
        int n = words.length;
        int[] orBits = new int[n];
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            char[] ch = words[i].toCharArray();
            for(int j = 0; j < ch.length; j++) {
                cnt |= (1 << ch[j] - 'a');
            }
            orBits[i] = cnt;
        }
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if((orBits[i] & orBits[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }
}