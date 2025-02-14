class 2D_FlattingLL {
    Node sortList(Node first, Node sec) {
        Node dummy = new Node(-1);
        Node newList = dummy;
        while(first != null && sec != null) {
            if(first.data < sec.data) {
                newList.bottom = first;
                newList = newList.bottom;
                first = first.bottom;
            } else {
                newList.bottom = sec;
                newList = newList.bottom;
                sec = sec.bottom;
            }
        }
        if(first != null) {
            newList.bottom = first;
        } else {
            newList.bottom = sec;
        }
        return dummy.bottom;
    }
    // Function to flatten a linked list
    Node flatten(Node root) {
        // code here
        
        if(root == null || root.next == null) {
            return root;
        }
        
        Node curr = root;
        Node dummy = new Node(-1);
        Node newList = dummy;
        while(curr != null) {
            newList.bottom = curr;
            curr = curr.bottom;
            newList = newList.bottom;
        }
        curr = root.next;
        while(curr != null) {
            newList = sortList(dummy.bottom, curr);
            curr = curr.next;
        }
        return dummy.bottom;
    }
}