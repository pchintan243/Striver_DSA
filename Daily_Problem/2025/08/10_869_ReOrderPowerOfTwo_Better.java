package Daily_Problem.2025.08;
import java.util.Arrays;

public class 10_869_ReOrderPowerOfTwo_Better {
    int[] countDigits(int n) {
        int[] digits = new int[10];
        while(n > 0) {
            digits[n % 10]++;
            n /= 10;
        }
        return digits;
    }
    public boolean reorderedPowerOf2(int n) {
        int[] digits = countDigits(n);

        for(int i = 0; i < 30; i++) {
            int powerOfTwo = 1 << i;

            int[] powerOfTwoCnt = countDigits(powerOfTwo);

            if(Arrays.equals(digits, powerOfTwoCnt)) {
                return true;
            }
        }

        return false;
    }
}