package facebook;

import java.util.*;

public class Q023_Merge_k_Sorted_Lists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode result = new ListNode(0);
        ListNode curr = result;
        PriorityQueue<ListNode> Q = new PriorityQueue<>((a, b) -> a.val-b.val);
        for (ListNode node : lists) {
            if (node == null) continue;
            Q.add(node);
        }
        while (!Q.isEmpty()) {
            ListNode node = Q.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null) Q.offer(node.next);
        }
        return result.next;
    }

}
