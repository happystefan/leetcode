package Y2020.facebook;

import java.util.PriorityQueue;

public class Q0023_Merge_k_Sorted_Lists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> Q = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) Q.add(list);
        }
        ListNode rslt = new ListNode(0);
        ListNode curr = rslt;
        while (!Q.isEmpty()) {
            ListNode node = Q.poll();
            curr.next = node;
            if (node.next != null) Q.add(node.next);
            curr = curr.next;
        }
        return rslt.next;
    }

}
