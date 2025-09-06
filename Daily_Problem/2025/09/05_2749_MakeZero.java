package Daily_Problem.2025.09;

public class 05_2749_MakeZero {
    public int makeTheIntegerZero(int num1, int num2) {
        int k = 1;
        while(true) {
            long x = num1 - (long) num2 * k;
            if(x < k) {
                return -1;
            }
            if(k >= Long.bitCount(x)) {
                return k;
            }
            k++;
        }
    }
}