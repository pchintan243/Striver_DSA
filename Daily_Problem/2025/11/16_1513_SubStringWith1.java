package Daily_Problem.2025.11;

public class 16_1513_SubStringWith1 {
    public int numSub(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();
        long ans = 0;
        int MOD = (int) 1e9 + 7;
        int i = 0;
        while(i < n) {
            int start = i;
            while(start < n && ch[start] == '1') {
                start++;
            }
            if(i == start) {
                i++;
            } else {
                int len = start - i;
                ans = (ans + ((long) len * (len + 1) / 2)) % MOD;
                i = start;
            }
        }

        return (int) ans;
    }
}
