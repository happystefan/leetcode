package Y2018.facebook;

public class Q141_Linked_List_Cycle {

    public boolean hasCycle(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;
        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) {
                return true;
            }
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
