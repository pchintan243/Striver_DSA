package Medium;
import java.util.HashMap;
import java.util.Map;

public class 347_TopKFreqElement {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
        Integer.compare(b[0], a[0]));

        for(int i :nums) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> data: mp.entrySet()) {
            pq.offer(new int[]{data.getValue(), data.getKey()});
        }
        int[] ans = new int[k];
        while(k-- > 0) {
            ans[k] = pq.poll()[1];
        }
        return ans;
    }
}