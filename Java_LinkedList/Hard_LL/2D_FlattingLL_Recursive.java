class 2D_FlattingLL_Recursive {
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
        
        Node mergeHead = flatten(root.next);
        root = sortList(root, mergeHead);
        
        return root;
    }
}
