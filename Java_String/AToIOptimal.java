class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;
        char[] ar = s.toCharArray();
        
        int sign = 1;
        int cnt = 0;
        long res = 0;

        if(ar[cnt] == '-') {
            sign = -1;
            cnt++;
        } else if(ar[cnt] == '+') {
            cnt++;
        }

        while(cnt < s.length() && Character.isDigit(ar[cnt])) {
            res = res * 10 + (ar[cnt] - '0');
            cnt++;

            if(res > Integer.MAX_VALUE) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

        }
        return (int) (sign * res);

    }
}