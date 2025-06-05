class 219ContainDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> st = new HashSet<>();

        for(int i = 0; i < n; i++) {
            if(i > k) {
                st.remove(nums[i - k - 1]);
            }
            if(st.contains(nums[i])) {
                return true;
            }
            st.add(nums[i]);
        }

        return false;
    }
}