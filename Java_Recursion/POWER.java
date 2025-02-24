class POWER {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1.0;
        if(n == 1) 
            return x;

        long exp = n;
        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }

        double ans = myPow(x, (int) (exp / 2));
        if(n % 2 == 0) {
            ans = ans * ans;
        } else {
            ans = (ans * ans) * x;
        }
        return ans;
    }
}