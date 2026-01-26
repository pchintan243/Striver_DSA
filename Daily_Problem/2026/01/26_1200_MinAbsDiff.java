package Daily_Problem.2026.01;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 26_1200_MinAbsDiff {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            min = Math.min(min, arr[i] - arr[i - 1]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1; i < n; i++) {
            if(arr[i] - arr[i - 1] == min) {
                ans.add(List.of(arr[i - 1], arr[i]));
            }
        }
        return ans;

    }
}
