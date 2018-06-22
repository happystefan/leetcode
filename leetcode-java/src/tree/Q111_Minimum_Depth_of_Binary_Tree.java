package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Q111_Minimum_Depth_of_Binary_Tree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minDepth(TreeNode root) {
        Queue<TreeNode> Q = new LinkedList<>();
        if (root != null) {
            Q.offer(root);
        }
        int result = 0;
        while (!Q.isEmpty()) {
            result++;
            int size = Q.size();
            while (size-- > 0) {
                TreeNode c = Q.poll();
                if (c.left == null && c.right == null) {
                    return result;
                }
                if (c.left != null) {
                    Q.offer(c.left);
                }
                if (c.right!= null) {
                    Q.offer(c.right);
                }
            }
        }
        return result;
    }

}
