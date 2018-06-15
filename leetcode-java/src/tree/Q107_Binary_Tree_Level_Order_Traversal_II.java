package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q107_Binary_Tree_Level_Order_Traversal_II {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> Q = new LinkedList<>();
        if (root != null) {
            Q.offer(root);
        }
        while (!Q.isEmpty()) {
            int size = Q.size();
            List<Integer> list = new LinkedList<>();
            while (size-- > 0) {
                TreeNode c = Q.poll();
                list.add(c.val);
                if (c.left != null) {
                    Q.offer(c.left);
                }
                if (c.right != null) {
                    Q.offer(c.right);
                }
            }
            result.add(0, list);
        }
        return result;
    }

}
