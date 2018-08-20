package archive.sort;

public class Q147_Insertion_Sort_List {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode(0);
        ListNode curr = head;
        ListNode next = head;
        ListNode prev = result;
        while (curr != null) {
            next = curr.next;
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }
            curr.next = prev.next;
            prev.next = curr;
            prev = result;
            curr = next;
        }
        return result.next;
    }

}
