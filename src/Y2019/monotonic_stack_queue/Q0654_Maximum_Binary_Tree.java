package Y2019.monotonic_stack_queue;

import java.util.*;

public class Q0654_Maximum_Binary_Tree {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: recursive
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution1 {

        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if (nums == null || nums.length == 0) return null;
            return construct(nums, 0, nums.length - 1);
        }

        private TreeNode construct(int[] nums, int l, int r) {
            if (l > r) return null;
            if (l == r) return new TreeNode(nums[l]);
            int idx = l, max = nums[l];
            for (int i = l; i <= r; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    idx = i;
                }
            }
            TreeNode root = new TreeNode(max);
            root.left = construct(nums, l, idx - 1);
            root.right = construct(nums, idx + 1, r);
            return root;
        }

    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: monotonic stack
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution2 {

        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if (nums == null || nums.length == 0) return null;
            Deque<TreeNode> deque = new ArrayDeque<>();
            for (int num : nums) {
                TreeNode node = new TreeNode(num);
                while (!deque.isEmpty() && deque.peekLast().val > num) {
                    node.left = deque.pollLast();
                }
                if (!deque.isEmpty()) deque.peekLast().right = node;
                deque.add(node);
            }
            return deque.peekFirst();
        }

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
