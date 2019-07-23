package Y2019.Q0001_Q0300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q0101_Symmetric_Tree {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: recursive
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public boolean isSymmetric_recursive(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return root1 == null && root2 == null;
        return root1.val == root2.val && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }


    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: iterative -- level order traversal
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public boolean isSymmetric_level_order_traversal(TreeNode root) {
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        while (!Q.isEmpty()) {
            List<TreeNode> list = new ArrayList<>(Q);
            int i = 0, j = list.size() - 1;
            while (i < j) {
                if (list.get(i) == null && list.get(j) == null) {
                    i++;
                    j--;
                    continue;
                }
                if (list.get(i) == null || list.get(j) == null) return false;
                if (list.get(i).val != list.get(j).val) return false;
                i++;
                j--;
            }
            int size = Q.size();
            while (size-- > 0) {
                TreeNode node = Q.poll();
                if (node == null) continue;
                Q.add(node.left);
                Q.add(node.right);
            }
        }
        return true;
    }


    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 3: iterative -- push two tree into queue
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        Q.add(root);
        while (!Q.isEmpty()) {
            TreeNode node1 = Q.poll();
            TreeNode node2 = Q.poll();
            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null) return false;
            if (node1.val != node2.val) return false;
            Q.add(node1.left);
            Q.add(node2.right);
            Q.add(node1.right);
            Q.add(node2.left);
        }
        return true;
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
