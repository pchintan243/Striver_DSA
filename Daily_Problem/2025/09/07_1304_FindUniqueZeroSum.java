package Daily_Problem.2025.09;

public class 07_1304_FindUniqueZeroSum {
    public int[] sumZero(int n) {
        if(n == 1) {
            return new int[]{0};
        }
        int[] ans = new int[n];
        int i = 0;
        int j = n - 1;
        if((n & 1) == 1) {
            i = 1;
            ans[0] = 0;
        }
        while(i < j) {
            ans[i] = j;
            ans[j] = -j;
            i++;
            j--;
        }

        return ans;
    }
}
