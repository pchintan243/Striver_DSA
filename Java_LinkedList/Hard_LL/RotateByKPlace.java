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

// Approach 1
class RotateByKPlace {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)
            return head;
        int len = 1;
        ListNode curr = head;
        while(curr.next != null) {
            curr = curr.next;
            len++;
        }
        k = k % len;
        if(k == 0) 
            return head;
        ListNode slow = head;
        ListNode fast = head;
        int cnt = k;
        while(cnt != 0) {
            fast = fast.next;
            cnt--;
        }

        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
}

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
class RotateByKPlace {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)
            return head;
        int len = 1;
        ListNode curr = head;
        while(curr.next != null) {
            curr = curr.next;
            len++;
        }
        k = k % len;
        if(k == 0) 
            return head;
        k = len - k;
        curr.next = head;
        while(k > 0) {
            curr = curr.next;
            k--;
        }

        head = curr.next;
        curr.next = null;
        return head;
    }
}