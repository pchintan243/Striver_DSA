/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ReverseLL {
    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode nextNd = head.next;
        ListNode last = null;

        while(current != null) {
            nextNd = current.next;
            current.next = last;
            last = current;
            current = nextNd;
        }

        return last;
    }
}