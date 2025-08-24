package BackTracking;
import java.util.ArrayList;
import java.util.List;

public class Combinations {
    void compute(int j, List<Integer> temp, int n, int k, List<List<Integer>> ans) {
        if(temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int ll = j; ll <= n; ll++) {
            temp.add(ll);
            compute(ll + 1, temp, n, k, ans);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        compute(1, new ArrayList<>(), n, k, ans);
        return ans;
    }
}

