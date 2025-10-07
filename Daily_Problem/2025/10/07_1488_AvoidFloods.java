package Daily_Problem.2025.10;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 07_1488_AvoidFloods {
    public int[] avoidFlood(int[] rain) {
        int n = rain.length;
        UnionFind uf = new UnionFind(n + 1);
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[n];
        Arrays.fill(res, 1);

        for (int i = 0; i < n; i++) {
            int lake = rain[i];

            if (lake != 0) {
                res[i] = -1;
                uf.unite(i);

                if (map.containsKey(lake)) {
                    int prev = map.get(lake);
                    int dry = uf.find(prev + 1);

                    if (dry >= i)
                        return new int[0];

                    res[dry] = lake;
                    uf.unite(dry);
                    map.put(lake, i);
                } else {
                    map.put(lake, i);
                }
            }
        }

        return res;
    }
}

class UnionFind {
    int[] parent;

    public UnionFind(int size) {
        parent = new int[size + 1];
        for (int i = 0; i <= size; i++) {
            parent[i] = i;
        }
    }

    public int find(int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent[i]);
    }

    public void unite(int i) {
        parent[i] = find(i + 1);
    }
}