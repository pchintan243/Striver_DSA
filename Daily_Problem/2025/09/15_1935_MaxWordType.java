package Daily_Problem.2025.09;

public class 15_1935_MaxWordType {
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] isVisited = new boolean[128];
        for(char c: brokenLetters.toCharArray()) {
            isVisited[c] = true;
        }
        int cnt = 0;
        int n = text.length();
        boolean corrupted = false;
        for(int i = 0; i < n; i++) {
            char c = text.charAt(i);
            if(c == ' ') {
                if(!corrupted) {
                    cnt++;
                }
                corrupted = false;
                continue;
            }
            if(corrupted) {
                continue;
            }
            if(isVisited[c]) {
                corrupted = true;
            }
        }
        if(!corrupted) {
            cnt++;
        }

        return cnt;
    }
}