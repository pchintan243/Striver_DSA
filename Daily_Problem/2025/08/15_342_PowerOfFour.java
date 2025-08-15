package Daily_Problem.2025.08;

public class 15_342_PowerOfFour {
    public boolean isPowerOfFour(int n) {
        if(n <= 0) {
            return false;
        }
        while(n != 0) {
            if(n == 1) {
                return true;
            }
            if(n % 4 != 0) {
                return false;
            }
            n /= 4;
        }
        return true;
    }
}