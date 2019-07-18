package Y2019.Q0001_Q0300;

public class Q0061_Rotate_List {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int len = getLength(head);
        k %= len;
        ListNode walker = head;
        ListNode runner = head;
        while (k-- > 0) runner = runner.next;
        while (runner.next != null) {
            walker = walker.next;
            runner = runner.next;
        }
        runner.next = head;
        ListNode result = walker.next;
        walker.next = null;
        return result;
    }

    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
