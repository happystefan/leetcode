package Q200_Q299;

public class Q206_Reverse_Linked_List {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
           ListNode tail = head.next;
           head.next = dummy.next;
           dummy.next = head;
           head = tail;
        }
        return dummy.next;
    }

}
