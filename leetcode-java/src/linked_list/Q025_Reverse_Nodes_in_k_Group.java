package linked_list;


public class Q025_Reverse_Nodes_in_k_Group {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = head;
        int cnt = 0;
        while (tail != null && cnt < k) {
            tail = tail.next;
            cnt++;
        }
        if (cnt != k) {
            return head;
        }
        tail = reverseKGroup(tail, k);
        return reverse(head, tail, k);
    }

    private ListNode reverse(ListNode head, ListNode tail, int k) {
        while (k-- > 0) {
            ListNode next = head.next;
            head.next = tail;
            head = next;
            tail = head;
        }
        return tail;
    }

}
