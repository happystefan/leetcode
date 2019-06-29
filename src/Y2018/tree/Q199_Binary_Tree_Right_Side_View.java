package Y2018.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q199_Binary_Tree_Right_Side_View {

    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> Q = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        if (root != null) {
            Q.offer(root);
        }
        while (!Q.isEmpty()) {
            result.add(Q.peek().val);
            int size = Q.size();
            while (size-- > 0) {
                TreeNode c = Q.poll();
                if (c.right != null) {
                    Q.offer(c.right);
                }
                if (c.left != null) {
                    Q.offer(c.left);
                }
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
