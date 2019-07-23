package Y2019.Q0001_Q0300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q0102_Binary_Tree_Level_Order_Traversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        while (!Q.isEmpty()) {
            int size = Q.size();
            List<Integer> list = new ArrayList<>(size);
            while (size-- > 0) {
                TreeNode node = Q.poll();
                list.add(node.val);
                if (node.left != null) Q.add(node.left);
                if (node.right != null) Q.add(node.right);
            }
            result.add(list);
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
