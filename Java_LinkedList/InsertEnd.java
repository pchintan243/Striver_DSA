class Solution {
    // Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x) {
        // code here
        Node res = new Node(x);
        if(head == null) {
            return res;
        }
        Node current = head;
        
        while(current.next != null) {
            current = current.next;
        }
        current.next = res;
        return head;
    }
}