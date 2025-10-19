package Daily_Problem.2025.10;
import java.util.LinkedList;
import java.util.Queue;

public class 19_1625_LexicographySmallString {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> visited = new HashSet<>();

        Queue<String> q = new LinkedList<>();
        q.offer(s);
        visited.add(s);
        int n = s.length();
        int pivotIndex = n - b;
        String ans = s;
        while(!q.isEmpty()) {
            String st = q.poll();
            if (st.compareTo(ans) < 0) {
                ans = st;
            }

            char[] ch = st.toCharArray();
            for(int i = 1; i < n; i = i + 2) {
                ch[i] = (char) (((ch[i] - '0') + a) % 10 + '0');
            }
            String newString = new String(ch);
            if(!visited.contains(newString)) {
                visited.add(newString);
                q.offer(newString);
            }

            String rotatedString = st.substring(pivotIndex) + st.substring(0, pivotIndex);
            if(!visited.contains(rotatedString)) {
                visited.add(rotatedString);
                q.offer(rotatedString);
            }
        }
        
        return ans;
    }
}