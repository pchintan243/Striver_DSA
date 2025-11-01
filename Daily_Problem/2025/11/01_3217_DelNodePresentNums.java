package Daily_Problem.2025.11;

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
class 01_3217_DelNodePresentNums {
    public ListNode modifiedList(int[] nums, ListNode head) {
        int max = 0;
        for(int i: nums) {
            max = Math.max(max, i);
        }
        max++;
        boolean[] isVisited = new boolean[max];
        for(int i: nums) {
            isVisited[i] = true;
        }
        ListNode ans = new ListNode(-1);
        ListNode curr = ans;
        while(head != null) {
            if(head.val >= max || !isVisited[head.val]) {
                curr.next = head;
                curr = curr.next;
            }
            head = head.next;
        }
        curr.next = null;
        return ans.next;
    }
}