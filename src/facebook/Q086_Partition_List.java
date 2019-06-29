package facebook;

public class Q086_Partition_List {

    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null && curr.val < x) {
            curr = curr.next;
            prev = prev.next;
        }

        ListNode insert_prev = prev;
        while (curr != null) {
            if (curr.val < x) {
                ListNode next = curr.next;
                curr.next = insert_prev.next;
                insert_prev.next = curr;
                insert_prev = insert_prev.next;
                prev.next = next;
                curr = next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}

