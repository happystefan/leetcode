package linked_list;

public class Q061_Rotate_List {

    public ListNode rotateRight(ListNode head, int k) {
        int len = length(head);
        k %= len;
        ListNode runner = head;
        ListNode walker = head;
        while (k-- > 0) {
            runner = runner.next;
        }
        while (runner.next != null) {
            walker = walker.next;
            runner = runner.next;
        }
        runner.next = head;
        ListNode result = walker.next;
        walker.next = null;
        return result;
    }

    private int length(ListNode head) {
        if (head == null) {
            return 0;
        }
        return 1 + length(head.next);
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}

