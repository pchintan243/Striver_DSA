package Daily_Problem.2025.08;

public class 26_3000_MaxRectangle {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n = dimensions.length;
        int ans = 0;
        double length = 0.0;
        for(int i = 0; i < n; i++) {
            int first = dimensions[i][0];
            int second = dimensions[i][1];

            double tempLength = Math.sqrt((first * first) + (second * second));
            if(tempLength > length) {
                length = tempLength;
                ans = first * second;
            } else if(tempLength == length) {
                int currentArea = first * second;
                if(currentArea > ans) {
                    ans = currentArea;
                }
            }
        }

        return ans;
    }
}