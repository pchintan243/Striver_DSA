class Add1 {
    public int findCarry(Node head) {
        if(head == null) {
            return 1;
        }
        int carry = findCarry(head.next);
        head.data = head.data + carry;
        if(head.data < 10) {
            return 0;
        } else {
            head.data = 0;
            return 1;
        }
    }
    public Node addOne(Node head) {
        // code here.
        int carry = findCarry(head);
        if(carry == 1) {
            Node ans = new Node(1);
            ans.next = head;
            return ans;
        }
        return head;
    }
}