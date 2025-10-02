package Daily_Problem.2025.10;

public class 02_3100_WaterBottles_II {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = 0;
        int empty = 0;
        int full = numBottles;
        while(empty + full >= numExchange) {
            ans += full;
            empty += full;
            full = 0;
            while(empty >= numExchange) {
                empty -= numExchange;
                numExchange++;
                full++;
            }
        }

        return ans + full;
    }
}