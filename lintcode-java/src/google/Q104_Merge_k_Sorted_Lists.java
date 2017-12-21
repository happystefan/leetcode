package google;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by mingqiangliang on 12/21/17.
 */
public class Q104_Merge_k_Sorted_Lists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
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
