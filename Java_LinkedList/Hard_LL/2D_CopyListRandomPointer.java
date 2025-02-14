/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class 2D_CopyListRandomPointer {
    public Node copyRandomList(Node head) {
        Node curr = head;
        while(curr != null) {
            Node temp = curr.next;
            Node newNode = new Node(curr.val);
            curr.next = newNode;
            newNode.next = temp;
            curr = temp;
        }
        curr = head;
        while(curr != null) {
            if(curr.random == null) {
                curr.next.random = null;
            } else {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        Node dummy = new Node(-1);
        Node ans = dummy;
        curr = head;
        while(curr != null && curr.next != null) {
            ans.next = curr.next;
            curr.next = curr.next.next;
            curr = curr.next;
            ans = ans.next;
        }

        return dummy.next;
    }
}