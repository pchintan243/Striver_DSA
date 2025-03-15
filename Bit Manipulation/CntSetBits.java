class CntSetBits{
    static int findx(int n) {
        int x = 0;
        while((1 << x) <= n) {
            x++;
        }
        
        return x - 1;
    }
    //Function to return sum of count of set bits in the integers from 1 to n.
    public static int countSetBits(int n){
        
        // Your code here
        
        // I/P = 13
        if(n <= 1)
            return n;
        int x = findx(n);
        int cntBits = 0;
        cntBits += (x * (1 << x - 1)); // above set bits cnt // 0 to 7 cnt = 12
        cntBits += n - (1 << x) + 1; // cnt first bit for num 8 to 13
        int rest = n - (1 << x); // find in 0 to (x - 1) index set bits
        int ans = cntBits + countSetBits(rest); // recuriseve call using rest bits

        return ans;
        
    }
}