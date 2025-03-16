class Divide2Integer {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor)
            return 1;
        boolean flag = true;
        if((dividend >= 0 && divisor < 0) || (dividend <= 0 && divisor > 0)) {
            flag = false;
        }
        long num = Math.abs(dividend);
        long d = Math.abs(divisor);
        long ans = 0;
        while(d <= num) {
            int x = 0;
            while((d << (x + 1)) <= num) {
                x++;
            }
            num -= (d * (1 << x));
            ans += (1 << x);
        }
        if((ans == (1 << 31)) && flag) {
            return Integer.MAX_VALUE;
        }
        if((ans == (1 << 31)) && !flag) {
            return Integer.MIN_VALUE;
        }
        return flag ? (int) ans : (int) -ans;
    }
}