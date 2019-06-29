package Y2018.facebook;

public class Q025_Reverse_Nodes_in_k_Group {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = new ListNode(0);
        ListNode curr = result;
        while (head != null) {
            ListNode l = head, r = head;
            int i = 1;
            for (; i < k; i++) {
                if (r.next == null) {
                    break;
                }
                r = r.next;
            }
            if (i != k) {
                while (head != null) {
                    curr.next = head;
                    head = head.next;
                    curr = curr.next;
                }
                break;
            }
            head = r.next;
            // reverse [l, r] and append to curr
            for (i = 0; i < k; i++) {
                ListNode tail = curr.next;
                curr.next = l;
                ListNode tmp = l.next;
                l.next = tail;
                l = tmp;
            }
            while (curr.next != null) {
                curr = curr.next;
            }
        }
        return result.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
