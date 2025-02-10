// 1st Approach
class 2D_RemoveDuplicates{
    Node removeDuplicates(Node head){
        // Code Here.
        Node dummy = head;
        Node temp = head;
        Node curr = head.next;
        while(curr != null) {
            if(curr.data == temp.data) {
                temp.next = curr.next;
                if(curr.next != null) {
                    curr.next.prev = temp;
                } else {
                    curr.prev = null;
                }
                curr = curr.next;
            } else {
                temp = curr;
                curr = curr.next;
            }
        }
        
        return dummy;
    }
}

// 2nd Approach
class 2D_RemoveDuplicates{
    Node removeDuplicates(Node head){
        // Code Here.
        if(head == null || head.next == null) return head;
        
        Node curr = head;
        while(curr != null && curr.next != null) {
            if(curr.data == curr.next.data) {
                curr.next = curr.next.next;
                if(curr.next != null) {
                    curr.next.prev = curr;
                }
            } else {
                curr = curr.next;
            }
        }
        
        return head;
    }
}

//3rd Approach
class 2D_RemoveDuplicates{
    Node removeDuplicates(Node head){
        // Code Here.
        if(head == null || head.next == null) return head;
        
        Node curr = head;
        while(curr != null && curr.next != null) {
            Node temp = curr.next;
            while(temp != null && curr.data == temp.data) {
                temp = temp.next;
            }
            curr.next = temp;
            if(temp != null) {
                temp.prev = curr;
            }
            curr = curr.next;
        }
        
        return head;
    }
}