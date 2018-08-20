package archive.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Q623_Add_One_Row_to_Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) {
            return root;
        }
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        d -= 2;
        while(d-- > 0) {
            int size = Q.size();
            if (size == 0) {
                return root;
            }
            while(size-- > 0) {
                TreeNode c = Q.poll();
                if (c.left != null) {
                    Q.offer(c.left);
                }
                if (c.right != null) {
                    Q.offer(c.right);
                }
            }
        }
        while(!Q.isEmpty()) {
            TreeNode c = Q.poll();
            TreeNode l = c.left, r = c.right;

            c.left = new TreeNode(v);
            c.left.left = l;

            c.right = new TreeNode(v);
            c.right.right = r;
        }
        return root;
    }

}
