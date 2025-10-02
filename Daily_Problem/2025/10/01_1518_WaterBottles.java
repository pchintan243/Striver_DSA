package Daily_Problem.2025.10;

public class 01_1518_WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        int rem = numBottles;
        while(rem >= numExchange) {
            int temp = rem / numExchange;
            if(temp == 0) {
                break;
            }
            ans += temp;
            rem = temp + (rem % numExchange);
        }
        return ans;
    }
}