package tree;

import java.util.ArrayList;
import java.util.List;

public class Q109_Convert_Sorted_List_to_Binary_Search_Tree {

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return toBST(list, 0, list.size() - 1);
    }

    private TreeNode toBST(List<Integer> list, int l, int r) {
        if (l > r) {
            return null;
        }
        if (l == r) {
            return new TreeNode(list.get(l));
        }
        int m = (l + r) / 2;
        TreeNode root = new TreeNode(list.get(m));
        root.left = toBST(list, l, m - 1);
        root.right = toBST(list, m + 1, r);
        return root;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
