public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        while (n >= 1) {
            if (n % 2 != 0 && n != 1) {
                return false;
            }
            if (n == 1) {
                return true;
            }
            n /= 2;
        }

        return false;
    }
}