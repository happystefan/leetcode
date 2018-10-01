package vmware.tree_traversal;

import java.util.*;

public class Q102_Binary_Tree_Level_Order_Traversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> Q = new LinkedList<>();
        if (root != null) Q.offer(root);
        while (!Q.isEmpty()) {
            int size = Q.size();
            List<Integer> list = new LinkedList<>();
            while (size-- > 0) {
                TreeNode curr = Q.poll();
                list.add(curr.val);
                if (curr.left != null) Q.offer(curr.left);
                if (curr.right!= null) Q.offer(curr.right);
            }
            result.add(list);
        }
        return result;
    }

}
