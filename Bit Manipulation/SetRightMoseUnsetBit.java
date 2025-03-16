class SetRightMoseUnsetBit {
    static int setBit(int n) {
        // code here
        int num = n;
        int x = 0;
        while((num & (1 << x)) >= 1) {
            x++;
        }
        return ((1 << x) ^ num);
    }
}