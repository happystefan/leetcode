package Y2019.Q0001_Q0300;

public class Q0086_Partition_List {

    public ListNode partition(ListNode head, int x) {
        ListNode dmy1 = new ListNode(0);
        ListNode dmy2 = new ListNode(0);
        ListNode l1 = dmy1, l2 = dmy2;
        while (head != null) {
            if (head.val < x) {
                l1.next = head;
                l1 = l1.next;
            } else {
                l2.next = head;
                l2 = l2.next;
            }
            head = head.next;
        }
        l2.next = null;
        l1.next = dmy2.next;
        return dmy1.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}
