class Divide2Integer {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }
        if(dividend == divisor)
            return 1;
        boolean flag = true;
        if((dividend >= 0 && divisor < 0) || (dividend <= 0 && divisor > 0)) {
            flag = false;
        }
        long num = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long ans = 0;
        while(d <= num) {
            int x = 0;
            while((d << (x + 1)) <= num) {
                x++;
            }
            num -= (d << x);
            ans += (1 << x);
        }

        if(!flag) {
            ans = -ans;
        }
        if(ans > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if(ans < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        
        return (int) ans;
    }
}