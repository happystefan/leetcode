package facebook;

public class Q142_Linked_List_Cycle_II {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;
        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) {
                runner = head;
                while (runner != walker) {
                    runner = runner.next;
                    walker = walker.next;
                }
                return runner;
            }
        }
        return null;
    }

}
