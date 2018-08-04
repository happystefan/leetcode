package facebook;

public class Q203_Remove_Linked_List_Elements_B {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode result = new ListNode(0);
        ListNode curr = result;
        while (head != null) {
            if (head != null && head.val == val) {
                head = head.next;
                continue;
            }
            ListNode next = head.next;
            head.next = null;
            curr.next = head;
            curr = curr.next;
            head = next;
        }
        return result.next;
    }

}