package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Q662_Maximum_Width_of_Binary_Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int widthOfBinaryTree(TreeNode root) {
        int result = 0;
        Queue<TreeNode> Q1 = new LinkedList<>();
        Queue<Integer> Q2 = new LinkedList<>();
        if (root != null) {
            Q1.offer(root);
            Q2.offer(1);
        }
        while (!Q1.isEmpty()) {
            int l = Q2.peek();
            int size = Q1.size();
            while (size-- > 0) {
                TreeNode c = Q1.poll();
                int r = Q2.poll();
                result = Math.max(result, r-l+1);
                if (c.left != null) {
                    Q1.offer(c.left);
                    Q2.offer(r*2);
                }
                if (c.right != null) {
                    Q1.offer(c.right);
                    Q2.offer(r*2+1);
                }
            }
        }
        return result;
    }

}
