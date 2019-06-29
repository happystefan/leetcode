package Y2018.vmware.tree_traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q145_Binary_Tree_Postorder_Traversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        List<Integer> result = new LinkedList<>();
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.add(0, curr.val);
            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
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
