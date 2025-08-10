class 10_869_ReOrderPowerOfTwo_Optimal {
    int countDigits(int n) {
        int cnt = 0;
        while(n > 0) {
            cnt += Math.pow(10, n % 10);
            n /= 10;
        }
        return cnt;
    }
    public boolean reorderedPowerOf2(int n) {
        int digits = countDigits(n);

        for(int i = 0; i < 30; i++) {
            if(digits == countDigits(1 << i)) {
                return true;
            }
        }

        return false;
    }
}