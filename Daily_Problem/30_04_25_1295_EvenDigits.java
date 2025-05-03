class 30_04_25_1295_EvenDigits {
    public int findNumbers(int[] nums) {
        int cnt = 0;
        for(int val: nums) {
            if(val >= 10 && val <= 99 || val >= 1000 && val <= 9999 || val >= 100000) {
                cnt++;
            }
        }

        return cnt;
    }
}