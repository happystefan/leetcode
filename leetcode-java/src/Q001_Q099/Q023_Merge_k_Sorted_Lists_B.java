package Q001_Q099;

import java.util.PriorityQueue;

/**
 * Created by mqliang on 6/1/17.
 */
public class Q023_Merge_k_Sorted_Lists_B {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (ListNode list : lists) {
            while (list != null) {
                queue.add(list.val);
                list = list.next;
            }
        }
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        while (!queue.isEmpty()) {
            cur.next = new ListNode(queue.poll());
            cur = cur.next;
        }
        return ans.next;
    }
}
