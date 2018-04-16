package facebook;

public class Q450_Reverse_Nodes_in_k_Group {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode nextHead = head;
        for (int i = 0; i < k; i++) {
            if (nextHead == null) {
                return head;
            }
            nextHead = nextHead.next;
        }

        ListNode tail = head.next;
        head.next = reverseKGroup(nextHead, k);

        for (int i = 0; i < k-1; i++) {
            ListNode newHead = tail;
            tail = tail.next;
            newHead.next = head;
            head = newHead;
        }
        return head;
    }

}
