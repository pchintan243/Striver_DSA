package Daily_Problem.2025.12;

class 08_1925_CntSquareSumTriples {
    public int countTriples(int n) {
        int ans = 0;
        for(int i = 3; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                int req = (int) Math.sqrt(i * i + j * j);
                if(req <= n && ((i * i) + (j * j)) == (req * req)) {
                    ans += 2;
                }
            }
        }
        return ans;
    }
}