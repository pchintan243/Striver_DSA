class CheckBitSet {
    static boolean checkKthBit(int num, int k) {
        // Your code here
        int i = 1;
        i = i << k;
        return (i & num) > 0;
    }
}
