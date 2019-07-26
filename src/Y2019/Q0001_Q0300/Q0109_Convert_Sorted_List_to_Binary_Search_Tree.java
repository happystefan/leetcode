package Y2019.Q0001_Q0300;

public class Q0109_Convert_Sorted_List_to_Binary_Search_Tree {

    private ListNode curr;

    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        curr = head;
        while (head != null) {
            head = head.next;
            len++;
        }

        return build(0, len - 1);
    }

    private TreeNode build(int l, int r) {
        if (l > r) return null;

        int m = l + (r - l) / 2;
        TreeNode left = build(l, m - 1);

        TreeNode root = new TreeNode(curr.val);
        curr = curr.next;

        root.left = left;
        root.right = build(m + 1, r);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
