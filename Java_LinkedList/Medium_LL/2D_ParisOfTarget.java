class 2D_ParisOfTarget {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Node left = head;
        Node right = head.next;
        while(right.next != null) {
            right = right.next;
        }
        
        while(left.data < right.data) {
            int sum = left.data + right.data;
            if(sum == target) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(left.data);
                temp.add(right.data);
                ans.add(temp);
                left = left.next;
                right = right.prev;
            } else if(sum < target) {
                left = left.next;
            } else {
                right = right.prev;
            }
        }
        
        return ans;
    }
}
        
