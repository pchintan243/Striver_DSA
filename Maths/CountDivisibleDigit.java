class CountDivisibleDigit {
    static int evenlyDivides(int n) {
        // code here
        int cnt = 0;
        int num = n;
        while(num != 0) {
            int temp = num % 10;
            if(temp != 0 && n % temp == 0)
                cnt++;
            num /= 10;
        }
        
        return cnt;
    }
}