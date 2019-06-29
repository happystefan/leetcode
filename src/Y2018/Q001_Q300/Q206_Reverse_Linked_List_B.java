package Y2018.Q001_Q300;

public class Q206_Reverse_Linked_List_B {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tail = head.next;
        ListNode newHead = reverseList(head.next);
        tail.next = head;
        head.next = null;
        return newHead;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
