import java.util.ArrayList;
import java.util.List;
class 01_118_PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(List.of(1));
        for(int i = 0; i < numRows - 1; i++) {
            List<Integer> last = ans.get(i);
            int n = last.size();

            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j = 0; j < n - 1; j++) {
                temp.add(last.get(j) + last.get(j + 1));
            }
            temp.add(1);
            ans.add(temp);
        }

        return ans;
        
    }
}