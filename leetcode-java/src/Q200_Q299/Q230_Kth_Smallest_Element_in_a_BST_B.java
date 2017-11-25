package Q200_Q299;

import java.util.Stack;

public class Q230_Kth_Smallest_Element_in_a_BST_B {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (k > 0) {
            TreeNode cur = stack.pop();
            k--;
            if (k == 0) return cur.val;
            TreeNode right = cur.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        return -1;
    }

}
