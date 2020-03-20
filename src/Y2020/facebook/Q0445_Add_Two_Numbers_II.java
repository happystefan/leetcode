package Y2020.facebook;

import java.util.Stack;

public class Q0445_Add_Two_Numbers_II {

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
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.add(l2.val);
            l2 = l2.next;
        }
        ListNode rslt = new ListNode(0);
        int c = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || c != 0) {
            if (!stack1.isEmpty()) c += stack1.pop();
            if (!stack2.isEmpty()) c += stack2.pop();
            ListNode tail = rslt.next;
            ListNode node = new ListNode(c % 10);
            node.next = tail;
            rslt.next = node;
            c /= 10;
        }
        return rslt.next;
    }

}
