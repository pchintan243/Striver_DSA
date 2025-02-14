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
class ReverseInKGroup {
    ListNode possibleToReverse(ListNode temp, int k) {
        k -= 1;
        while(temp != null && k > 0) {
            temp = temp.next;
            k--;
        }
        return temp;
    }
    public ListNode reverseLL(ListNode head) {

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
            
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            ListNode lastNode = possibleToReverse(curr, k);
            
            if(lastNode != null) {
                ListNode preserve = lastNode.next;
                lastNode.next = null;
                reverseLL(curr);
                if(curr == head) {
                    head = lastNode;
                } else {
                    prev.next = lastNode;
                }
                prev = curr;
                curr.next = preserve;
                curr = preserve;
            } else {
                break;
            }
        }

        return head;
    }
}