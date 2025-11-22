package Daily_Problem.2025.11;

class 22_3190_Make3Divisible {
    public int minimumOperations(int[] nums) {
        int cnt = 0;
        for(int i: nums) {
            if(i % 3 != 0) {
                cnt++;
            }
        }

        return cnt;
    }
}