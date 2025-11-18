package Daily_Problem.2025.11;

class 18_717_1bitChar {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        for(int i = 0; i < n; i++) {
            if(bits[i] == 1) {
                i++;
                if(i == n - 1) {
                    return false;
                }
            }
        }
        return true;
    }
}