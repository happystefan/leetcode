package Y2019.Q0001_Q0300;

public class Q0025_Reverse_Nodes_in_k_Group {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode nextKGroup = head;
        int kk = k;
        while (kk-- > 0) {
            if (nextKGroup == null) return head;
            nextKGroup = nextKGroup.next;
        }
        ListNode tmp = head;
        ListNode dummy = new ListNode(0);
        while (head != nextKGroup) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        tmp.next = reverseKGroup(nextKGroup, k);
        return dummy.next;
    }

}
