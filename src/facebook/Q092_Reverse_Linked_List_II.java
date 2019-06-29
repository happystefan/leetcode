package facebook;

public class Q092_Reverse_Linked_List_II {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 1; i < m; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;
        ListNode next = curr.next;

        // 1->2->3->4->5->NULL, m = 2, n = 4
        // 1->3->2->4->5->NULL
        // 1->4->3->2->5->NULL
        for (int i = m; i < n; i++) {
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = curr.next;
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
