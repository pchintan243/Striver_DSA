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

 // First Soln which takes space complexity
public class IntersectionLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode firstNode = headA;
        ListNode secNode = headB;

        if(headA.next == null || headB.next == null) {
            return headA.val == headB.val ? headA : null;
        }

        List<Integer> lista = new ArrayList<>();
        List<Integer> listb = new ArrayList<>();
        
        while(headA != null) {
            lista.add(headA.val);
            headA = headA.next;
        }

        while(headB != null) {
            listb.add(headB.val);
            headB = headB.next;
        }
        int sa = lista.size();
        int sb = listb.size();
        int i = sa - 1;
        int j = sb - 1;
        Integer ans = null;
        while(i != 0 && j != 0) {

            if(lista.get(i) != listb.get(j)) {
                break;
            }
            ans = lista.get(i);

            i--;
            j--;
        }
        if(ans == null) return null;
        ListNode tempA = headA;
        ListNode tempB = headB;
        int cnt1 = 0;
        while(cnt1 < i) {
            firstNode = firstNode.next;
            cnt1++;
        }

        int cnt2 = 0;
        while(cnt2 < j) {
            secNode = secNode.next;
            cnt2++;
        }

        while(i < sa && j < sb) {
            if(firstNode == secNode) {
                return new ListNode(firstNode.val);
            }
            firstNode = firstNode.next;
            secNode = secNode.next;
            i++;
            j++;
        }
        
        return new ListNode(ans);
        
    }
}