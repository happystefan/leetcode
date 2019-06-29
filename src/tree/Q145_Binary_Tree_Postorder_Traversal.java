package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q145_Binary_Tree_Postorder_Traversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode c = stack.pop();
            result.add(0, c.val);
            if (c.left != null) {
                stack.push(c.left);
            }
            if (c.right != null) {
                stack.push(c.right);
            }
        }
        return result;
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
