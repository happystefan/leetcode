package archive.Q001_Q300;

public class Q147_Insertion_Sort_List {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        ListNode cur = head;    // current node need to be inserted
        ListNode nxt = null;    // next node need to be inserted

        while (cur != null) {
            nxt = cur.next;
            ListNode pos = dummy; // insert node between pos and pos.next
            while (pos.next != null && pos.next.val < cur.val) {
                pos = pos.next;
            }
            cur.next = pos.next;
            pos.next = cur;
            cur = nxt;
        }
        return dummy.next;
    }

}
