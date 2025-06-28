import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
class MinPlatformBetter {
    public int findPlatform(int[] Arrival, int[] Departure) {
        //your code goes here
        Map<Integer, List<Integer>> mp = new LinkedHashMap<>();
        
        int n = Arrival.length;
        int[][] temp = new int[n][2];

        for(int i = 0; i < n; i++) {
            temp[i][0] = Arrival[i];
            temp[i][1] = Departure[i];
        }

        Arrays.sort(temp, (a, b) -> Integer.compare(a[1], b[1]));
        int pcnt = 1;
        for(int i = 0; i < n; i++) {
            if(mp.isEmpty()) {
                mp.putIfAbsent(pcnt, new ArrayList<>());
                mp.get(pcnt).add(temp[i][1]);
                pcnt++;
            } else {
                int maxDepart = Integer.MIN_VALUE;
                int minPlatform = 0;

                for(Map.Entry<Integer, List<Integer>> data: mp.entrySet()) {
                    int key = data.getKey();
                    int val = data.getValue().get(data.getValue().size() - 1);

                    if(temp[i][0] > val && val > maxDepart) {
                        maxDepart = val;
                        minPlatform = key;
                    }
                }

                if(maxDepart == Integer.MIN_VALUE) {
                    mp.putIfAbsent(pcnt, new ArrayList<>());
                    mp.get(pcnt).add(temp[i][1]);
                    pcnt++;
                } else {
                    mp.get(minPlatform).add(temp[i][1]);
                }
            }
        }

        return mp.size();
    }
}
