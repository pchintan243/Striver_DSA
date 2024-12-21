import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 1; i <= numRows; i++) {
            res.add(generateNCR(i));
        }
        return res;
    }

    private static List<Integer> generateNCR(int row) {
        List<Integer> res = new ArrayList<>();

        int ans = 1;
        res.add(1);

        for(int i = 1; i < row; i++) {
            ans *= row - i;
            ans /= i;
            res.add(ans);
        }
        return res;
    }
}