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
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode ans = head;
        int cnt = 0;


        while(current != null) {
            cnt++;
            current = current.next;
            
            if(cnt % 2 == 0) {
                ans = ans.next;
            }
        }

        return ans;
    }
}