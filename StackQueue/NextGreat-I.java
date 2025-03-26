class NextGreat-I {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int[] greater = new int[100001];
        int[] res = new int[nums1.length];
        Arrays.fill(greater, -1);
        for(int i = 0; i < nums2.length; i++) {
            while(!st.isEmpty() && nums2[st.peek()] < nums2[i]) {
                greater[nums2[st.pop()]] = nums2[i];
            }
            st.push(i);
        }
        for(int i = 0; i < nums1.length; i++) {
            res[i] = greater[nums1[i]];
        }
        return res;
    }
}