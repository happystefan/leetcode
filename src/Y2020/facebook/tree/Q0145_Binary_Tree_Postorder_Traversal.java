package Y2020.facebook.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q0145_Binary_Tree_Postorder_Traversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> rslt = new LinkedList<>();
        if (root != null) stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            rslt.add(0, curr.val);
            if (curr.left != null) stack.add(curr.left);
            if (curr.right != null) stack.add(curr.right);
        }
        return rslt;
    }

}
