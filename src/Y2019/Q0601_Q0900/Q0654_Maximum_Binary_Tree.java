package Y2019.Q0601_Q0900;

import java.util.*;

public class Q0654_Maximum_Binary_Tree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        for (int num : nums) {
            TreeNode node = new TreeNode(num);
            while (!deque.isEmpty() && deque.peekLast().val < num) {
                node.left = deque.pollLast();
            }
            if (!deque.isEmpty()) deque.peekLast().right = node;
            deque.addLast(node);
        }
        return deque.pollFirst();
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
