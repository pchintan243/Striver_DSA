package Daily_Problem.2025.08;

public class 16_1323_Max69Num {
    public int maximum69Number (int num) {
        int n = num;
        int cnt = 0;
        int temp = 0;
        while(n != 0) {
            int rem = n % 10;
            if(rem == 6) {
                temp = 3 * (int) Math.pow(10, cnt);
            }
            cnt++;
            n /= 10;
        }
        num += temp;
        return num;
    }
}