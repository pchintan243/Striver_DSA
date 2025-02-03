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
class RemoveNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        // Move fast to the nth time
        while(n != 0) {
            fast = fast.next;
            n--;
        }
        
        // if Fast is null then we need to remove head from the list
        if(fast == null) 
            return head.next;
            
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;

        return head;
    }
}