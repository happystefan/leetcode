package Y2019.Q0001_Q0300;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q0094_Binary_Tree_Inorder_Traversal {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: recursive
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public List<Integer> inorderTraversal_dfs(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        dfs(result, root);
        return result;
    }

    private void dfs(List<Integer> result, TreeNode root) {
        if (root == null) return;
        dfs(result, root.left);
        result.add(root.val);
        dfs(result, root.right);
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: iterative
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        List<Integer> result = new LinkedList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
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
