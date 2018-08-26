package facebook;

public class Q143_Reorder_List {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        ListNode walker = head;
        ListNode runner = head;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        ListNode p1 = head.next;
        ListNode p2 = reverse(walker.next);
        walker.next = null;

        ListNode curr = head;
        int cnt = 0;
        while (p1 != null || p2 != null) {
            if (cnt %2 == 0) {
                curr.next = p2;
                p2 = p2.next;
            } else {
                curr.next = p1;
                p1 = p1.next;
            }
            curr = curr.next;
            cnt++;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }

}
