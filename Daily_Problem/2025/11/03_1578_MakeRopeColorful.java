package Daily_Problem.2025.11;

public class 03_1578_MakeRopeColorful {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0;
        int n = neededTime.length;
        char[] ch = colors.toCharArray();
        for(int i = 1; i < n; i++) {
            if(ch[i] == ch[i - 1]) {
                ans += Math.min(neededTime[i], neededTime[i - 1]);
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            }
        }
        return ans;
    }
}