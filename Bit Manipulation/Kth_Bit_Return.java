class Kth_Bit_Return {
    static boolean checkKthBit(int num, int k) {
        // Your code here
        StringBuilder res = new StringBuilder();
        int storeNum = num;
        while(storeNum != 1) {
            if(storeNum % 2 == 1) {
                res.append('1');
            } else {
                res.append('0');
            }
            storeNum /= 2;
        }
        res.append('1');

        int n = res.length();
        if(k >= n) {
            return false;
        }
        char ind = res.charAt(k);
        return ind == '1';
    }
}
