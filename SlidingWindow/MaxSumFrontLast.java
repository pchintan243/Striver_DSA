class MaxSumFrontLast {
    public int maxScore(int[] cardScore, int k) {
        //your code goes here
        int i = 0;
        int n = cardScore.length;
        int sum = 0;
        int temp = k;
        int leftSum = 0;
        while(temp != 0) {
            leftSum += cardScore[i++];
            temp--;
        }
        sum = leftSum;
        while(k != 0) {
            leftSum = leftSum - cardScore[k - 1] + cardScore[n - temp - 1];
            sum = Math.max(sum, leftSum);
            temp++;
            k--;
        }
        return sum;
    }
}