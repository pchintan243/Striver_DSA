package  Medium;

public class 38_CountAndSay {
    public String countAndSay(int n) {
        String result = "1";

        for (int i = 1; i < n; i++) {
            result = buildNext(result);
        }

        return result;
    }

    private String buildNext(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char prev = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == prev) {
                count++;
            } else {
                sb.append(count).append(prev);
                prev = curr;
                count = 1;
            }
        }

        sb.append(count).append(prev);
        return sb.toString();
    }
}