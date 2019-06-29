package facebook;

public class Q019_Remove_Nth_Node_From_End_of_List {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode runner = head;
        ListNode walker = head;
        ListNode prev = dummy;
        while (n-- > 0) {
            runner = runner.next;
        }
        while (runner != null) {
            prev = walker;
            runner = runner.next;
            walker = walker.next;
        }
        prev.next = walker.next;
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
