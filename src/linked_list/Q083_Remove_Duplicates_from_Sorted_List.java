package linked_list;

public class Q083_Remove_Duplicates_from_Sorted_List {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode(0);
        ListNode curr = result;
        ListNode l = head;
        while (l != null) {
            ListNode r = l;
            while (r.next != null && r.next.val == r.val) {
                r = r.next;
            }
            if (l == r) {
                curr.next = l;
                ListNode lnext = l.next;
                l.next = null;
                curr = curr.next;
                l = lnext;
            } else {
                l = r.next;
            }
        }
        return result.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
