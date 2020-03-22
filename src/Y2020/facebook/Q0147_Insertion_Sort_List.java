package Y2020.facebook;

public class Q0147_Insertion_Sort_List {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rslt = new ListNode(0);
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            node.next = null;
            insert(rslt, node);
            node = next;
        }
        return rslt.next;
    }

    private void insert(ListNode rslt, ListNode node) {
        ListNode curr = rslt;
        while (curr.next != null && curr.next.val < node.val) {
            curr = curr.next;
        }
        node.next = curr.next;
        curr.next = node;
    }

}
