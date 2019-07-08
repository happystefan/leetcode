package Y2019.Q0001_Q0300;

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
        PriorityQueue<ListNode> Q = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (ListNode list : lists) {
            if (list != null) Q.add(list);
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!Q.isEmpty()) {
            ListNode node = Q.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null) Q.add(node.next);
        }
        return dummy.next;
    }

}
