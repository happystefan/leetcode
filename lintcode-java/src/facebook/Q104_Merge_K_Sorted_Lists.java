package facebook;

import java.util.List;

public class Q104_Merge_K_Sorted_Lists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode mergeKLists(List<ListNode> lists) {

        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        while (true) {
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for (int i = 0; i < lists.size(); i++) {
                ListNode list = lists.get(i);
                if (list == null) {
                    continue;
                }
                if (list.val < min) {
                    min = list.val;
                    idx = i;
                }
            }
            if (idx == -1) {
                return result.next;
            }
            dummy.next = new ListNode(min);
            dummy = dummy.next;

            ListNode list = lists.get(idx);
            list = list.next;
            lists.remove(idx);
            lists.add(idx, list);
        }

    }

}
