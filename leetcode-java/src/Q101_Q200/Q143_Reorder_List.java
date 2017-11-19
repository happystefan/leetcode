package Q101_Q200;

public class Q143_Reorder_List {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;

        // 1, 2, 3, 4       // p1=2
        // 1, 2, 3, 4, 5    // p1=3
        // 1, 2, 3, 4, 5, 6 // p1=3
        ListNode p1 = head, p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        ListNode premid = p1, precur = p1.next;
        while (precur.next != null) {
            ListNode cur = precur.next;
            precur.next = cur.next;
            cur.next = premid.next;
            premid.next = cur;
        }

        p1 = head;
        p2 = premid.next;
        while (p1 != premid) {
            premid.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = premid.next;
        }
    }

}
