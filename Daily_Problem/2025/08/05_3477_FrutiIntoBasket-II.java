package Daily_Problem.2025.08;

public class 05_3477_FrutiIntoBasket-II {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;

        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(fruits[i] <= baskets[j]) {
                    ans++;
                    baskets[j] = -1;
                    break;
                }
            }
        }

        return n - ans;
    }
}