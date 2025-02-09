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
public class InterSection_Optimal {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode firstNode = headA;
        ListNode secNode = headB;
        while(firstNode != null && secNode != null) {
            firstNode = firstNode.next;
            secNode = secNode.next;

            if(firstNode == secNode) {
                return firstNode;
            }
            if(firstNode == null) {
                firstNode = headB;
            }
            if(secNode == null) {
                secNode = headA;
            }

        }

        return null;
    }
}