package archive.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q144_Binary_Tree_Preorder_Traversal_B {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new LinkedList<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode c = stack.pop();
            result.add(c.val);
            if (c.right!= null) {
                stack.push(c.right);
            }
            if (c.left != null) {
                stack.push(c.left);
            }
        }
        return result;
    }

}
