package vmware;

public class Q206_Reverse_Linked_List_B {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // without dummy node
    public ListNode reverseList(ListNode head) {
        ListNode result = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = result;
            result = head;
            head = next;
        }
        return result;
    }
    
}
