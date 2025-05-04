class 04_05_2025_1128_CntDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int n = dominoes.length;

        int ans = 0;
        for(int i = 0; i < n - 1; i++) {
            int first = dominoes[i][0];
            int sec = dominoes[i][1];
            for(int j = i + 1; j < n; j++) {
                int nf = dominoes[j][0];
                int ns = dominoes[j][1];

                if((first == nf && sec == ns) || (first == ns && sec == nf)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}