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
    public ListNode findMiddleNode(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode ans = head;


        while(current.next != null && current.next.next != null) {
            current = current.next.next;
            ans = ans.next;
        }

        return ans;
    }
    public ListNode reverseLinkedList(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseLinkedList(head.next);
        ListNode current = head.next;
        current.next = head;
        head.next = null;
        return newHead;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode middle = findMiddleNode(head);
        
        ListNode newHead = reverseLinkedList(middle.next);

        ListNode first = head;
        ListNode second = newHead;
        while(second != null) {
            if(first.val != second.val) {
                reverseLinkedList(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }

        reverseLinkedList(newHead);
        return true;
    }
}