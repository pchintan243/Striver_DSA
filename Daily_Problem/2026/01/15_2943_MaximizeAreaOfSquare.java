package Daily_Problem.2026.01;
import java.util.Arrays;

public class 15_2943_MaximizeAreaOfSquare {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int hmax = 0;
        int vmax = 0;
        int cnt = 0;
        for (int i = 0; i < hBars.length - 1; i++) {
            if (hBars[i + 1] - hBars[i] == 1) {
                cnt++;
            } else {
                cnt = 0;
            }
            hmax = Math.max(hmax, cnt);
        }
        cnt = 0;
        for (int i = 0; i < vBars.length - 1; i++) {
            if (vBars[i + 1] - vBars[i] == 1) {
                cnt++;
            } else {
                cnt = 0;
            }
            vmax = Math.max(vmax, cnt);
        }
        int side = Math.min(hmax, vmax) + 2;
        return side * side;
    }
}
