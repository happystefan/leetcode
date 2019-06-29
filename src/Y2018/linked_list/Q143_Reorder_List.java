package Y2018.linked_list;

public class Q143_Reorder_List {

    public void reorderList(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;
        ListNode prev = null;
        while (runner != null && runner.next != null) {
            prev = walker;
            walker = walker.next;
            runner = runner.next.next;
        }
        if (prev == null) {
            return;
        }
        prev.next = null;

        ListNode r = reverse(walker);
        ListNode l = head.next;
        ListNode curr = head;
        int i = 1;
        while (l != null && r != null) {
            if (i % 2 == 0) {
                curr.next = l;
                l = l.next;
            } else {
                curr.next = r;
                r = r.next;
            }
            curr = curr.next;
            i++;
        }
        if (l != null) curr.next = l;
        if (r != null) curr.next = r;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head.next;
        head.next = null;
        while (tail != null) {
            ListNode next = tail.next;
            tail.next = head;
            head = tail;
            tail = next;
        }
        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}

