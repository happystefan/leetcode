package Y2020.facebook;

public class Q0148_Sort_List {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode walker = head;
        ListNode runner = head;
        ListNode prev = null;
        while (runner != null && runner.next != null) {
            prev = walker;
            walker = walker.next;
            runner = runner.next.next;
        }
        prev.next = null;
        return merge(sortList(head), sortList(walker));
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode rslt = new ListNode(0);
        ListNode curr = rslt;
        while (l != null && r != null) {
            if (l.val < r.val) {
                curr.next = l;
                l = l.next;
            } else {
                curr.next = r;
                r = r.next;
            }
            curr = curr.next;
        }
        if (l != null) curr.next = l;
        if (r != null) curr.next = r;
        return rslt.next;
    }

}
