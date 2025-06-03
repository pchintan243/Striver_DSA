import java.util.ArrayList;
import java.util.List;

class 54SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;

        while(top <= bottom && left <= right) {
            for(int j = left; j <= right; j++) {
                ans.add(matrix[top][j]);
            }
            top++;
            for(int j = top; j <= bottom; j++) {
                ans.add(matrix[j][right]);
            }
            right--;

            if(top <= bottom) {
                for(int j = right; j >= left; j--) {
                    ans.add(matrix[bottom][j]);
                }
                bottom--;
            }

            if(left <= right) {
                for(int j = bottom; j >= top; j--) {
                    ans.add(matrix[j][left]);
                }
                left++;
            }
        }

        return ans;
    }
}