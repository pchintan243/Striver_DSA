package Daily_Problem.2025.10;

public class 16_2598_SmallNonNegativeInteger {
    public int findSmallestInteger(int[] nums, int value) {
        int[] rem = new int[value];
        int res = 0;

        for(int i: nums) {
            int r = ((i % value) + value) % value;
            rem[r]++;
        }

        while(rem[res % value]-- > 0) {
            res++;
        }
        return res;
    }
}