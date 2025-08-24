package Hard_LL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        Map<Integer, List<ListNode>> mp = new TreeMap<>();
        for(ListNode i: lists) {
            if(i == null) {
                continue;
            }
            ListNode k = i;
            while(k != null) {
                mp.putIfAbsent(k.val, new ArrayList<>());
                mp.get(k.val).add(k);
                k = k.next;
            }
        }
        ListNode ans = new ListNode(-1);
        ListNode curr = ans;
        for(Map.Entry<Integer, List<ListNode>> data: mp.entrySet()) {
            List<ListNode> lst = data.getValue();
            System.out.println(lst.size());
            for(int i = 0; i < lst.size(); i++) {
                curr.next = lst.get(i);
                curr = curr.next;
            }
        }
        return ans.next;
    }
}
