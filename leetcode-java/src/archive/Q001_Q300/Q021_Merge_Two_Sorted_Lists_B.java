package archive.Q001_Q300;

/**
 * Created by mqliang on 5/31/17.
 */
public class Q021_Merge_Two_Sorted_Lists_B {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.val = l1.val;
                l1 = l1.next;
            } else {
                cur.val = l2.val;
                l2 = l2.next;
            }

            if (l1 != null && l2 != null) {
                cur.next = new ListNode(0);
                cur = cur.next;
            }
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        return ans;
    }
}
