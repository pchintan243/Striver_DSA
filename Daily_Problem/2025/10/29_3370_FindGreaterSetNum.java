package Daily_Problem.2025.10;

class 29_3370_FindGreaterSetNum {
    public int smallestNumber(int n) {
        int x = n;
        while((x & (x + 1)) != 0) {
            x++;
        }
        return x;
    }
}