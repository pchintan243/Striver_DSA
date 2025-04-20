package Contest.154_Biweekly;

class UniqueXORTriplet-II {
    public int uniqueXorTriplets(int[] nums) {
        Set<Integer> uniqueXORs = new HashSet<>();
        Set<Integer> uniqueNums = new HashSet<>();
        
        // Collect unique numbers
        for (int num : nums) {
            uniqueNums.add(num);
        }
        
        // Convert to array for faster access
        Integer[] uniqueArray = uniqueNums.toArray(new Integer[0]);
        int m = uniqueArray.length;

        Set<Integer> mid = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                mid.add(uniqueArray[i] ^ uniqueArray[j]);
            }
        }
        for(int l : mid) {
            for (int k = 0; k < m; k++) {
                uniqueXORs.add(l ^ uniqueArray[k]);
            }
        }
        
        return uniqueXORs.size();
    }
}