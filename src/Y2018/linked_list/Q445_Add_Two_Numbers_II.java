package Y2018.linked_list;

import java.util.Stack;

public class Q445_Add_Two_Numbers_II {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode result = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = !stack1.isEmpty() ? stack1.pop() : 0;
            int b = !stack2.isEmpty() ? stack2.pop() : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            ListNode prev = new ListNode(sum % 10);
            prev.next = result;
            result = prev;
        }
        return result;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
