package Y2019.Q0001_Q0300;

import java.util.LinkedList;
import java.util.Queue;

public class Q0111_Minimum_Depth_of_Binary_Tree {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: recursive
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int l = root.left == null ? Integer.MAX_VALUE : minDepth(root.left);
        int r = root.right == null ? Integer.MAX_VALUE : minDepth(root.right);
        return 1 + Math.min(l, r);
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: level order traversal
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public int minDepth_level_order_traversal(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        int result = 0;
        while (!Q.isEmpty()) {
            result++;
            int size = Q.size();
            while (size-- > 0) {
                TreeNode node = Q.poll();
                if (node.left == null && node.right == null) return result;
                if (node.left != null) Q.add(node.left);
                if (node.right != null) Q.add(node.right);
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
