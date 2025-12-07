package Daily_Problem.2025.12;
import java.util.Arrays;

public class 01_2141_MaxRunTimeOfNComputer {
    public long maxRunTime(int n, int[] batteries) {
        long totalEnergy = 0;
        for (int battery : batteries) {
            totalEnergy += battery;
        }

        Arrays.sort(batteries);

        for (int i = batteries.length - 1; i >= 0; i--) {
            if (batteries[i] > totalEnergy / n) {
                totalEnergy -= batteries[i];
                n--;
            } else {
                break;
            }
        }

        return totalEnergy / n;
    }
}