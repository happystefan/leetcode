package Y2019.Q0001_Q0300;

public class Q0082_Remove_Duplicates_from_Sorted_List_II {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: allocate new list
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public ListNode deleteDuplicates_solution1(ListNode head) {
        ListNode dmy = new ListNode(0);
        ListNode cur = dmy;
        int val = 0;
        int cnt = 0;
        while (head != null) {
            if (cnt == 0) {
                val = head.val;
                cnt++;
            } else {
                if (head.val == val) {
                    cnt++;
                } else {
                    if (cnt == 1) {
                        cur.next = new ListNode(val);
                        cur = cur.next;
                    }
                    val = head.val;
                    cnt = 1;
                }
            }
            head = head.next;
        }
        if (cnt == 1) cur.next = new ListNode(val);
        return dmy.next;
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: delete duplicates in place
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dmy = new ListNode(0);
        ListNode cur = dmy;
        while (head != null) {
            boolean duplicate = false;
            while (head.next != null && head.val == head.next.val) {
                duplicate = true;
                head = head.next;
            }
            if (!duplicate) {
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
