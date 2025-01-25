class Solution {
    // Function to insert a new node at given position in doubly linked list.
    Node addNode(Node head, int p, int data) {
        Node current = head;
        while(p > 0) {
            current = current.next;
            p--;
        }
        Node d = new Node(data);
        d.next = current.next;
        if(current.next != null) {
            Node tempNode = current.next;
            tempNode.prev = d;
            // or current.next.prev = d;
        }
        current.next = d;
        d.prev = current;
        return current;
    }
}