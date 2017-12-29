package google;

import java.util.PriorityQueue;

public class Q023_Merge_k_Sorted_Lists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pqueue = new PriorityQueue();
        for (ListNode list : lists) {
            while (list != null) {
                pqueue.add(list.val);
                list = list.next;
            }
        }
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        while (!pqueue.isEmpty()) {
            cur.next = new ListNode(pqueue.poll());
            cur = cur.next;
        }
        return ans.next;
    }

}
