package Y2018.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q094_Binary_Tree_Inorder_Traversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode c = stack.pop();
            result.add(c.val);
            c = c.right;
            while (c != null) {
                stack.push(c);
                c = c.left;
            }
        }
        return result;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
