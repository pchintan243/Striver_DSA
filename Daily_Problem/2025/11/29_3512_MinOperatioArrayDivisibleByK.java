package Daily_Problem.2025.11;

class 29_3512_MinOperatioArrayDivisibleByK {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for(int i : nums) {
            sum += i;
        }

        return sum % k;
    }
}