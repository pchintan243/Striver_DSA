class 2D_DelAtPos {
    public Node deleteNode(Node head, int x) {
        // code here
        Node current = head;
        
        if(x == 1) {
            Node ans = current.next;
            current.next = null;
            ans.prev = null;
            return ans;
        }
        
        while(x > 1) {
            current = current.next;
            x--;
        }
        
        if(current.next == null) {
            current.prev.next = null;
            current.prev = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        return head;
        
    }
}