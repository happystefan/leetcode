package facebook;

public class Q223_Palindrome_Linked_List {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode mid = findMid(head);
        ListNode r = mid.next;
        ListNode l = head;
        r = reverse(r);
        while (l != null && r != null) {
            if (l.val != r.val) {
                return false;
            }
            l = l.next;
            r = r.next;
        }
        return true;
    }

    private ListNode findMid(ListNode head) {
        ListNode walker = head;
        ListNode runner = head.next;
        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        return walker;
    }

    private ListNode reverse(ListNode head) {
        ListNode result = null;
        while (head != null) {
            ListNode tail = head.next;
            head.next = result;
            result = head;
            head = tail;
        }
        return result;
    }

}
