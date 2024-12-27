public class 27_12_24 {
    public int maxScoreSightseeingPair(int[] values) {
        int maxSum = Integer.MIN_VALUE;
        int temp = values[0];
        for(int i = 1; i < values.length; i++) {
            if((temp + values[i] - i) > maxSum) {
                maxSum = temp + values[i] - i;
            } 
            if(values[i] + i > temp) {
                temp = values[i] + i;
            }
        }

        return maxSum;
    }    
}
