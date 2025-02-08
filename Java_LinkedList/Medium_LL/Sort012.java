class Sort012 {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        // add your code here
        Node zeroHead = new Node(-1);
        Node zero = zeroHead;
        Node oneHead = new Node(-1);
        Node one = oneHead;
        Node twoHead = new Node(-1);
        Node two = twoHead;
        Node current = head;
        while(current != null) {
            if(current.data == 0) {
                zero.next = current;
                zero = current;
            } else if(current.data == 1) {
                one.next = current;
                one = current;
            } else {
                two.next = current;
                two = current;
            }
            current = current.next;
        }
    
        zero.next = oneHead.next != null ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;
        
        return zeroHead.next;
    }
}