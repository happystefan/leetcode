package Y2018.Q001_Q300;

public class Q203_Remove_Linked_List_Elements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null) {
            while (head != null && head.val == val) {
                head = head.next;
            }
            pre.next = head;
            if (head == null) break;
            pre = pre.next;
            head = head.next;
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
