package Y2019.Q0001_Q0300;

public class Q0083_Remove_Duplicates_from_Sorted_List {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dmy = new ListNode(0);
        ListNode cur = dmy;
        while (head != null) {
            if (cur == dmy || head.val != cur.val) {
                cur.next = head;
                cur = cur.next;
            }
            head = head.next;
        }
        cur.next = null;
        return dmy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
