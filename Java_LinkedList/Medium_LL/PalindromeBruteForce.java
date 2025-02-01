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
class PalindromeBruteForce {
    public boolean isPalindrome(ListNode head) {
        List<Integer> ans = new ArrayList<>();

        while(head != null) {
            ans.add(head.val);
            head = head.next;
        }

        int n = ans.size() - 1;
        for(int i = 0; i < ans.size() / 2; i++) {
            if(ans.get(i) != ans.get(n - i)) {
                return false;
            }
        }

        return true;
    }
}