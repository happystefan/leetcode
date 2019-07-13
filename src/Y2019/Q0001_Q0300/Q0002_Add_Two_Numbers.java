package Y2019.Q0001_Q0300;

public class Q0002_Add_Two_Numbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;

            if (carry == 0 && l1 == null) {
                curr.next = l2;
                break;
            }
            if (carry == 0 && l2 == null) {
                curr.next = l1;
                break;
            }
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
