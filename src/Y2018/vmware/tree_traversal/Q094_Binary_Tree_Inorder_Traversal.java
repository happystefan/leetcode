package Y2018.vmware.tree_traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q094_Binary_Tree_Inorder_Traversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        List<Integer> result = new LinkedList<>();
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
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
