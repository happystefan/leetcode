package archive.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q515_Find_Largest_Value_in_Each_Tree_Row {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Queue<TreeNode> Q = new LinkedList<>();
        if (root != null) {
            Q.offer(root);
        }
        while (!Q.isEmpty()) {
            int size = Q.size();
            int max = Integer.MIN_VALUE;
            while (size-- > 0) {
                TreeNode c = Q.poll();
                max = Math.max(max, c.val);
                if (c.left != null) {
                    Q.offer(c.left);
                }
                if (c.right != null) {
                    Q.offer(c.right);
                }
            }
            result.add(max);
        }
        return result;
    }

}
