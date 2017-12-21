package google;

import java.util.List;

/**
 * Created by mingqiangliang on 12/21/17.
 */
public class Q104_Merge_k_Sorted_Lists_B {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        while (true) {
            int idx = -1;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < lists.size(); i++) {
                if (lists.get(i) != null && lists.get(i).val < min) {
                    min = lists.get(i).val;
                    idx = i;
                }
            }

            if (idx != -1) {
                cur.next = new ListNode(min);

                ListNode l = lists.get(idx);
                l = l.next;
                lists.remove(idx);
                lists.add(idx, l);

                cur = cur.next;
            }
            else return ans.next;
        }
    }

}
