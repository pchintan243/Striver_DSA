package Daily_Problem.2026.04;

public class 04_2075_DecodeSlantedCipher {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        StringBuilder ans = new StringBuilder();
        int m = n / rows;
        for(int i = 0; i < m; i++) {
            int j = i;
            int r = 0;
            while(r < rows && j < m) {
                ans.append(encodedText.charAt(r * m + j));
                r++;
                j++;
            }
        }
        int end = ans.length() - 1;
        while(end >= 0 && ans.charAt(end) == ' ') {
            end--;
        }
        return ans.substring(0, end + 1);
    }
}
