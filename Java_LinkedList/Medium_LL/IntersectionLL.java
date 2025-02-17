/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class IntersectionLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode firstNode = headA;
        ListNode secNode = headB;
        while(firstNode != secNode) {
            firstNode = firstNode == null ? headB : firstNode.next;
            secNode = secNode == null ? headA : secNode.next;
        }

        return firstNode;
    }
}