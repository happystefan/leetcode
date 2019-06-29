package Y2018.Q001_Q300;

import java.util.PriorityQueue;

/**
 * Created by mqliang on 5/31/17.
 */
public class Q023_Merge_k_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.val < o2.val) {
                return -1;
            } else if (o1.val == o2.val) {
                return 0;
            } else {
                return 1;
            }
        });

        for (ListNode list : lists) {
            if (list != null) queue.add(list);
        }

        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null) queue.add(cur.next);
        }
        return ans.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
