class MaxSumFrontLast {
    public int maxScore(int[] cardScore, int k) {
        //your code goes here
        int i = 0;
        int n = cardScore.length;
        int j = n - 1;
        int sum = 0;
        int temp = k;
        int leftSum = 0;
        int rightSum = 0;
        while(temp != 0) {
            leftSum += cardScore[i++];
            rightSum += cardScore[j--];
            temp--;
        }
        sum = Math.max(leftSum, rightSum);
        while(k != 0) {
            leftSum = leftSum - cardScore[k - 1] + cardScore[n - temp - 1];
            rightSum = rightSum - cardScore[n - k] + cardScore[temp];
            sum = Math.max(sum, Math.max(leftSum, rightSum));
            temp++;
            k--;
        }
        return sum;
    }
}