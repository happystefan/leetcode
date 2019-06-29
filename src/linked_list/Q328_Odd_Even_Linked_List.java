package linked_list;

public class Q328_Odd_Even_Linked_List {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd_dummy = new ListNode(0);
        ListNode even_dummy = new ListNode(0);
        ListNode odd = odd_dummy;
        ListNode even = even_dummy;
        int cnt = 1;
        while (head != null) {
            ListNode next = head.next;
            if (cnt % 2 == 1) {
                odd.next = head;
                odd = odd.next;
                odd.next = null;
            } else {
                even.next = head;
                even = even.next;
                even.next = null;
            }
            head = next;
            cnt++;
        }
        odd.next = even_dummy.next;
        return odd_dummy.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
