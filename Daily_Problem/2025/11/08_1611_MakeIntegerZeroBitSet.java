package Daily_Problem.2025.11;

class 08_1611_MakeIntegerZeroBitSet {
    public int minimumOneBitOperations(int n) {
        if(n == 0) {
            return 0;
        }
        int k = 0;
        int curr = 1;
        while(curr * 2 <= n) {
            curr *= 2;
            k++;
        }
        return (1 << (k + 1)) - 1 - minimumOneBitOperations(n ^ curr);
    }
}