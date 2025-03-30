class 30_03_25_763_PartitionInd {
    int findInd(String s, int i) {
        int j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                j--;
            } else {
                break;
            }
        }

        return j;
    }
    public List<Integer> partitionLabels(String s) {
        Map<Character, int[]> mp = new LinkedHashMap<>();
        char[] ch = s.toCharArray();
        int n = s.length() - 1;
        for(int i = 0; i < s.length(); i++) {

            if(!mp.containsKey(ch[i])) {
                int lastInd = s.lastIndexOf(ch[i]);
                mp.put(ch[i], new int[]{i, lastInd});
            }
        }

        List<Integer> ans = new ArrayList<>();
        int firstInd = 0;
        int maxInd = mp.get(ch[0])[1];
        for (Map.Entry<Character, int[]> entry : mp.entrySet()) {
            
            int key = entry.getValue()[0];
            int val = entry.getValue()[1];
            if(key == 0) 
                continue;
            
            if(maxInd > key) {
                maxInd = Math.max(maxInd, val);
            } else {
                ans.add(maxInd - firstInd + 1);
                maxInd = val;
                firstInd = key;
            }
        }
        ans.add(maxInd - firstInd + 1);

        return ans;
    }
}