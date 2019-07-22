package Y2019.Q0001_Q0300;

public class Q0092_Reverse_Linked_List_II {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 0; i < m - 1; i++) prev = prev.next;
        ListNode nodem = prev.next;
        ListNode curr = nodem;
        for (int i = m; i <= n; i++) {
            ListNode next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = next;
        }
        nodem.next = curr;
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
