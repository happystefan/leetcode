package linked_list;

public class Q024_Swap_Nodes_in_Pairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head.next.next;
        tail = swapPairs(tail);
        ListNode next = head.next;
        next.next = head;
        head.next = tail;
        return next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
