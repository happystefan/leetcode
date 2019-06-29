package facebook;

public class Q025_Reverse_Nodes_in_k_Group_B {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = head;
        int count = 0;
        while (tail != null && count != k) {
            tail = tail.next;
            count++;
        }
        if (count != k) return head;
        tail = reverseKGroup(tail, k);
        head = reverse(head, tail, k);
        return head;
    }

    private ListNode reverse(ListNode head, ListNode tail, int k) {
        while (k-- > 0) {
            ListNode tmp = head.next;
            head.next = tail;
            tail = head;
            head = tmp;
        }
        return tail;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
