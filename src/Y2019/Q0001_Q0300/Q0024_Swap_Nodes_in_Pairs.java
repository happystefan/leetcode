package Y2019.Q0001_Q0300;


public class Q0024_Swap_Nodes_in_Pairs {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: iterative
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public ListNode swapPairs_iterative(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;
            ListNode tail = second.next;

            curr.next = second;
            second.next = first;
            first.next = null;
            curr = first;

            head = tail;
        }
        curr.next = head;
        return dummy.next;
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: recursive
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode tail = second.next;
        head = second;
        second.next = first;
        first.next = swapPairs(tail);
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
