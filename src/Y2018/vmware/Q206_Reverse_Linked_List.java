package Y2018.vmware;

public class Q206_Reverse_Linked_List {

    // with dummy node
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
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
