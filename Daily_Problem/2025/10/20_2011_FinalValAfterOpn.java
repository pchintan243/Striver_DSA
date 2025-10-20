package Daily_Problem.2025.10;

public class 20_2011_FinalValAfterOpn {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for(String s: operations) {
            if(s.contains("+")) {
                ans++;
            } else {
                ans--;
            }
        }

        return ans;
    }
}
