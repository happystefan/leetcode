package Q001_Q300;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q103_Binary_Tree_Zigzag_Level_Order_Traversal_B {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean order = true;
        while (!queue.isEmpty()) {
            int num = queue.size();
            List<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < num; i++) {
                if (queue.peek().left != null) queue.add(queue.peek().left);
                if (queue.peek().right != null) queue.add(queue.peek().right);

                if (order) {
                    levelList.add(queue.poll().val);
                } else {
                    levelList.add(0, queue.poll().val);
                }
            }
            ans.add(levelList);
            order = !order;
        }

        return ans;
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
