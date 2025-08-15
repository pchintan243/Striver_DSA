package Daily_Problem.2025.08;

class 08_808_SoupServings {
    private Double[][] cache;

    double prob(int a, int b) {

        if(a <= 0 && b <= 0) {
            return 0.5;
        }
        if(a <= 0) {
            return 1.0;
        }
        if(b <= 0) {
            return 0.0;
        }

        if(cache[a][b] != null) {
            return cache[a][b];
        }
        double cnt1 = prob(a - 4, b);
        double cnt2 = prob(a - 3, b - 1);
        double cnt3 = prob(a - 2, b - 2);
        double cnt4 = prob(a - 1, b - 3);

        double val = 0.25 * (cnt1 + cnt2 + cnt3 + cnt4);
        cache[a][b] = val;
        return val;
    }
    public double soupServings(int n) {
        if (n >= 4800) {
            return 1.0;
        }

        int val = (n + 24) / 25;
        cache = new Double[val + 1][val + 1];
        return prob(val, val);
    }
}