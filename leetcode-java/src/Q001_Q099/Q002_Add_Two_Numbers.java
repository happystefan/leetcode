package Q001_Q099;

/**
 * Created by mqliang on 5/27/17.
 */
public class Q002_Add_Two_Numbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode ans = new ListNode(0);
        ListNode sum = ans;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            sum.val = carry;
            if (l1 != null) {
                sum.val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum.val += l2.val;
                l2 = l2.next;
            }

            carry = sum.val/10;
            sum.val %= 10;

            if (l1 != null || l2 != null || carry != 0) {
                sum.next = new ListNode(0);
                sum = sum.next;
            }
        }
        return ans;
    }
}
