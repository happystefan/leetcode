package Y2018.vmware;

public class Q206_Reverse_Linked_List_C {

    // recursive
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tail = reverseList(head.next);
        head.next.next = head;
        head.next = null;
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
