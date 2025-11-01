package Daily_Problem.2025.10;

public class 31_3289_TwoSneakyNumber {
    public int[] getSneakyNumbers(int[] nums) {
        int first = -1;
        int[] freq = new int[101];
        for(int i: nums) {
            if(freq[i] == 0) {
                freq[i]++;
            } else {
                if(first == -1) {
                    first = i;
                } else {
                    return new int[]{first, i};
                }
            }
        }

        return new int[]{-1, -1};
    }
}