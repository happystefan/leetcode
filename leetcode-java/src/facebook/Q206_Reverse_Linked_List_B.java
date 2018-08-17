package facebook;

public class Q206_Reverse_Linked_List_B {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head.next;
        ListNode result = reverseList(head.next);
        head.next = null;
        tail.next  = head;
        return result;
    }

}
