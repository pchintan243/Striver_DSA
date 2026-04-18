package Daily_Problem.2026.04;

class 18_3783_MirrorDistance {
    private int reverse(int n) {
        int ans = 0;
        while(n != 0) {
            int temp = n % 10;
            ans = ans * 10 + temp;
            n /= 10;
        }
        return ans;
    }
    public int mirrorDistance(int n) {
        int reverseNum = reverse(n);
        return Math.abs(n - reverseNum);
    }
}