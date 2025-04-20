import java.util.Arrays;
class 20_04_2025_781_RabbitsForest {
    public int numRabbits(int[] answers) {
        Arrays.sort(answers);
        int n = answers.length;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            int temp = answers[i];
            int tempCnt = 0;
            while(i > 0 && i < n && tempCnt < temp && answers[i] == answers[i - 1]) {
                i++;
                tempCnt++;
            }
            if(i == n) {
                return sum;
            }
            sum += answers[i] + 1;
        }

        return sum;
    }
}