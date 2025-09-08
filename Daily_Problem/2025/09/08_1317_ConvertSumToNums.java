package Daily_Problem.2025.09;

public class 08_1317_ConvertSumToNums {
    public int[] getNoZeroIntegers(int n) {
        if(n == 11) {
            return new int[]{2, 9};
        }
        int first = 1;
        int second = n - 1;
        int temp = n - 1;
        
        while(true) {
            boolean flag = false;
            while(temp != 0) {
                int rem = temp % 10;
                if(rem == 0) {
                    first += 16;
                    second -= 16;
                    flag = true;
                    break;
                }
                temp /= 10;
            }
            temp = second;
            if(!flag)
                return new int[]{first, second};
        }
    }
}