package Q001_Q300;

/**
 * Created by mqliang on 5/30/17.
 */
public class Q019_Remove_Nth_Node_From_End_of_List {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode l = ans, r = ans;
        while (n-- > 0) r = r.next;
        while (r.next != null) {
            r = r.next;
            l = l.next;
        }
        if (l.next != null) {
            l.next = l.next.next;
        }
        return ans.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
