class 2D_DelAllOccurence2D_DelAllOccurence {
    static Node deleteAllOccurOfX(Node head, int x) {
        
        Node dummy = new Node();
        dummy.next = head;
        Node curr = head;
        Node last = dummy;
        
        while(curr != null) {
            if(curr.data == x) {
                last.next = curr.next;
                if(curr.next != null) {
                    curr.next.prev = last;
                }
                curr = last.next;
            } else {
                last = curr;
                curr = curr.next;
            }
        }
        
        return dummy.next;
    }
}