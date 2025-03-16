class TwoOddOccur
{
    int findx(int num) {
        int x = 0;
        while((num & (1 << x)) == 0) {
            x++;
        }
        
        return x;
    }
    public int[] twoOddNum(int arr[], int n)
    {
        // code here
        int xor = 0;
        for(int i = 0; i < n; i++) {
            xor ^= arr[i];
        }
        
        int b1 = 0;
        int b2 = 0;
        
        int x = findx(xor);
        
        for(int num: arr) {
            if(((num >> x) & 1) == 1) {
                b1 ^= num;
            } else {
                b2 ^= num;
            }
        }
        if(b1 < b2) {
            b1 = b1 ^ b2;
            b2 = b1 ^ b2;
            b1 = b1 ^ b2;
        }
        return new int[]{b1, b2};
    }
}