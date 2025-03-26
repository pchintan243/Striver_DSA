class NextGreat-II {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] greater = new int[n];
        Arrays.fill(greater, -1);
        for(int i = 0; i < (2 * n); i++) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i % n]) {
                greater[st.pop()] = nums[i % n];
            }
            if(i < n){
                st.push(i);
            }
        }
        return greater;
    }
}