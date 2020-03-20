package Y2020.facebook;

public class Q0002_Add_Two_Numbers {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode rslt = new ListNode(0);
        ListNode curr = rslt;
        int c = 0;
        while (l1 != null || l2 != null || c != 0) {
            if (l1 != null) {
                c += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                c += l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(c % 10);
            c /= 10;
            curr = curr.next;
        }
        return rslt.next;
    }

}


