package Daily_Problem.2025.10;

public class 23_3461_CheckDigitsAfterEqual {
    public boolean hasSameDigits(String s) {
        int[] arr = new int[s.length()];
        int i = 0;
        for(char c: s.toCharArray()) {
            arr[i++] = c - '0';
        }
        for(int j = s.length(); j > 2; j--) {
            for(int k = 0; k < j - 1; k++) {
                arr[k] = (arr[k] + arr[k + 1]) % 10;
            }
        }
        return arr[0] == arr[1];
    }
}