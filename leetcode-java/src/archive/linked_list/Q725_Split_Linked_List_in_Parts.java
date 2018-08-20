package archive.linked_list;

public class Q725_Split_Linked_List_in_Parts {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = len(root);
        ListNode[] result = new ListNode[k];
        int remaining = len%k;
        k = len/k;
        int i = 0;
        while (root != null) {
            result[i++] = root;
            ListNode prev = null;
            for (int j = 0; j < k; j++) {
                prev = root;
                root = root.next;
            }
            if (remaining > 0) {
                prev = root;
                root = root.next;
                remaining--;
            }
            prev.next = null;
        }
        return result;
    }

    private int len(ListNode root) {
        int result = 0;
        while (root != null) {
            result++;
            root = root.next;
        }
        return result;
    }

}
