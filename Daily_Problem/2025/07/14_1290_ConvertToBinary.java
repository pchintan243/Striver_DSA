package Daily_Problem.2025.07;

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
public class 14_1290_ConvertToBinary {
    private int findLength(ListNode head) {
        int n = 0;
        while(head.next != null) {
            head = head.next;
            n++;
        }

        return n;
    }
    public int getDecimalValue(ListNode head) {
        ListNode curr = head;
        int n = findLength(curr);
        int ans = 0;
        while(head != null) {
            if(head.val == 1) 
                ans += (1 << n);
            head = head.next;
            n--;
        }
        System.out.print(n);
        return ans;
    }
}