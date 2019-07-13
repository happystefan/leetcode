package Y2019.Q0001_Q0300;

public class Q0019_Remove_Nth_Node_From_End_of_List {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode runner = dummy, walker = dummy;
        while (n-- > 0) runner = runner.next;
        while (runner.next != null) {
            runner = runner.next;
            walker = walker.next;
        }
        walker.next = walker.next == null ? null : walker.next.next;
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
