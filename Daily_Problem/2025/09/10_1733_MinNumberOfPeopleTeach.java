package Daily_Problem.2025.09;

public class 10_1733_MinNumberOfPeopleTeach {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> frds = new HashSet<>();
        int len = languages.length;
        BitSet[] bit = new BitSet[len];

        for(int i = 0; i < len; i++) {
            bit[i] = new BitSet();
            for(int l: languages[i]) {
                bit[i].set(l);
            }
        }
        
        for(int[] f: friendships) {
            BitSet t = (BitSet) bit[f[0] - 1].clone();
            t.and(bit[f[1] - 1]);

            if(t.isEmpty()) {
                frds.add(f[0] - 1);
                frds.add(f[1] - 1);
            }
        }

        int ans = 0;
        int[] cnt = new int[n + 1];

        for(int f: frds) {
            for(int l: languages[f]) {
                cnt[l]++;
                ans = Math.max(ans, cnt[l]);
            }
        }

        return frds.size() - ans;
    }
}

// O(Len∗Languages[I])