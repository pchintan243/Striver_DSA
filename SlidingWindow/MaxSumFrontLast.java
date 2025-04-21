class MaxSumFrontLast {
    public int maxScore(int[] cardScore, int k) {
        //your code goes here
        int n = cardScore.length;
        int sum = 0;
        int leftSum = 0;
        for(int i = 0; i < k; i++) {
            leftSum += cardScore[i];
        }
        sum = leftSum;

        for(int i = 0; i < k; i++) {
            leftSum = leftSum + cardScore[n - i - 1] - cardScore[k - i - 1];
            sum = Math.max(sum, leftSum);
        }
        return sum;
    }
}