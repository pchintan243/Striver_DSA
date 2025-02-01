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
class Solution {
    public ListNode MiddleNodeOptimal(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode ans = head;


        while(current != null && current.next != null) {
            current = current.next.next;
            ans = ans.next;
        }

        return ans;
    }
}