class 03_05_2025_1007_MinDomino {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int first = tops[0];
        int sec = bottoms[0];
        int cnt1 = 0;
        int cnt2 = 0;

        for(int i = 0; i < n; i++) {
            if(tops[i] == first || bottoms[i] == first) {
                cnt1++;
            }
            if(tops[i] == sec || bottoms[i] == sec) {
                cnt2++;
            }
        }
        if(cnt1 != n && cnt2 != n) {
            return -1;
        }
        int num = 0;
        if(cnt1 == n) {
            num = first;
        } else {
            num = sec;
        }
        int ans = 0;
        int equalCnt = 0;
        for(int i = 0; i < n; i++) {
            if(tops[i] == num) {
                if(bottoms[i] == num)
                    equalCnt++;
            } else {
                ans++;
            }
        }
        return Math.min(ans, n - ans - equalCnt);
    }
}