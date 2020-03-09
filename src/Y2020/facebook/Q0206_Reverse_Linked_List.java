package Y2020.facebook;

public class Q0206_Reverse_Linked_List {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class solution1_iterative {

        public ListNode reverseList(ListNode head) {
            if (head == null) return null;
            ListNode dumy = new ListNode(0);
            while (head != null) {
                ListNode next = head.next;
                head.next = dumy.next;
                dumy.next = head;
                head = next;
            }
            return dumy.next;
        }

    }

    class solution1_recursive {

        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode tail = head.next;
            ListNode rslt = reverseList(head.next);
            head.next = null;
            tail.next = head;
            return rslt;
        }

    }

}
