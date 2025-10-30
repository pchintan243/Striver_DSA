package Daily_Problem.2025.10;

public class 1526_MinOperationToMakeArr {
    public int minNumberOperations(int[] target) {
        int ans = target[0];
        int n = target.length;
        
        for(int i = 1; i < n; i++) {
            if(target[i] >= target[i - 1]) {
                ans += (target[i] - target[i - 1]);
            }
        }
        return ans;
    }
}
