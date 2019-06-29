package Y2018.facebook;

public class Q021_Merge_Two_Sorted_Lists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode curr = result;
        while (l1 != null || l2 != null) {
            if (l2 == null || (l1 != null && l2 != null && l1.val < l2.val)) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
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
