package Daily_Problem.2025.11;

public class 13_3228_MoveOneEnd {
    public int maxOperations(String s) {
        int n = s.length();
        int total_ops = 0;
        int ones_count = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '1') {
                ones_count++;
            } else if (i > 0 && s.charAt(i - 1) == '1') {
                total_ops += ones_count;
            }
        }
        
        return total_ops;
    }
}