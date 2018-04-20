package facebook;

import java.util.*;

public class Q651_Binary_Tree_Vertical_Order_Traversal {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<TreeNode> node_queue = new LinkedList<>();
        Queue<Integer> index_queue = new LinkedList<>();
        node_queue.offer(root);
        index_queue.offer(0);

        while (!node_queue.isEmpty()) {
            TreeNode node = node_queue.poll();
            int index = index_queue.poll();
            map.computeIfAbsent(index, k -> new LinkedList<>());
            map.get(index).add(node.val);
            if (node.left != null) {
                node_queue.offer(node.left);
                index_queue.offer(index-1);
            }
            if (node.right != null) {
                node_queue.offer(node.right);
                index_queue.offer(index+1);
            }
        }

        List<List<Integer>> result = new LinkedList<>();
        result.addAll(map.values());

        return result;
    }

}
