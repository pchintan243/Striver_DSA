package Daily_Problem.2025.12;

class 07_1523_CntOddNumber {
    public int countOdds(int low, int high) {
        int ans = 0;
        if(low % 2 == 1) {
            low++;
            ans++;
        }
        if(high % 2 == 1) {
            high--;
            ans++;
        }

        return ans + (high - low) / 2;
    }
}