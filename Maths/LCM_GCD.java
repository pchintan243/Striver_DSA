class LCM_GCD {
    public static int[] lcmAndGcd(int a, int b) {
        // code here
        int x = a > b ? a : b;
        int y = b < a ? b : a;
        //eucleadian therom 
        while(x % y != 0){
           int rem = x % y;
           x = y;
           y = rem;
        }
        return new int[]{(a * b) / y, y};
    }
}