package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q637_Average_of_Levels_in_Binary_Tree {

    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> Q = new LinkedList<>();
        if (root != null) {
            Q.offer(root);
        }
        List<Double> result = new LinkedList<>();
        while (!Q.isEmpty()) {
            int size = Q.size();
            int cnt = size;
            double sum = 0;
            while (size-- > 0) {
                TreeNode c = Q.poll();
                sum += c.val;
                if (c.left != null) {
                    Q.offer(c.left);
                }
                if (c.right != null) {
                    Q.offer(c.right);
                }
            }
            result.add(sum / cnt);
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
