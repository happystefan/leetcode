package facebook;

public class Q234_Palindrome_Linked_List {

    public boolean isPalindrome(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;
        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        if (runner != null) {
            walker = walker.next;
        }
        walker = reverse(walker);
        while (walker != null) {
            if (walker.val != head.val) {
                return false;
            }
            walker = walker.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = new ListNode(0);
        ListNode result = prev;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev.next;
            prev.next = head;
            head = next;
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
