package facebook;

public class Q035_Reverse_Linked_List {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tail = head.next;
        head.next = null;
        while (tail != null) {
            ListNode newHead = tail;

            tail = tail.next;
            newHead.next = head;
            head = newHead;
        }
        return head;
    }

}


