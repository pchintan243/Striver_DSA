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
class SortLL {
    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    public ListNode merge(ListNode leftHead, ListNode rightHead) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while(leftHead != null && rightHead != null) {
            if(leftHead.val < rightHead.val) {
                temp.next = leftHead;
                leftHead = leftHead.next;
            } else {
                temp.next = rightHead;
                rightHead = rightHead.next;
            }
            temp = temp.next;
        }

        if(leftHead != null) {
            temp.next = leftHead;
        } else {
            temp.next = rightHead;
        }

        return head.next;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode middle = findMiddle(head);

        ListNode leftHead = head;
        ListNode rightHead = middle.next;
        middle.next = null;
        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);
        return merge(leftHead, rightHead);
    }
}