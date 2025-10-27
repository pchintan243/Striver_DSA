package Daily_Problem.2025.10;

public class 27_2125_NumberLaserBank {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int prev = 0;
        int ans = 0;
        for(String s: bank) {
            int curr = 0;
            for(int k = 0; k < s.length(); k++) {
                curr += s.charAt(k) - '0';
            }
            if(curr == 0) {
                continue;
            }
            ans += (prev * curr);
            prev = curr;
        
        }

        return ans;
    }
}