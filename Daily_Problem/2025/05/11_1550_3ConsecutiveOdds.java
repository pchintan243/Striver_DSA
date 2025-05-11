class 11_1550_3ConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        int cnt = 0;
        for(int num : arr) {
            if((num & 1) == 1)
                cnt++;
            else
                cnt = 0;
            if(cnt == 3)
                return true;
        }
        return false;
    }
}