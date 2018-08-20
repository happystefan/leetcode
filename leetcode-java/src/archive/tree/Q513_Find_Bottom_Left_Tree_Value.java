package archive.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Q513_Find_Bottom_Left_Tree_Value {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> Q = new LinkedList<>();
        if (root != null) {
            Q.offer(root);
        }
        int result = 0;
        while (!Q.isEmpty()) {
            TreeNode c = Q.poll();
            if (c.right != null) {
                Q.offer(c.right);
            }
            if (c.left != null) {
                Q.offer(c.left);
            }
            result = c.val;
        }
        return result;
    }

}
