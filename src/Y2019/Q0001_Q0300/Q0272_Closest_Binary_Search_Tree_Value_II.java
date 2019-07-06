package Y2019.Q0001_Q0300;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q0272_Closest_Binary_Search_Tree_Value_II {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Iterator {
        Iterator(TreeNode root, double target, boolean isPrev) {
            this.isPrev = isPrev;
            while (root != null) {
                if (root.val > target) {
                    if (isPrev) stack.push(root);
                    root = root.left;
                } else {
                    if (!isPrev) stack.push(root);
                    root = root.right;
                }
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public int next() {
            TreeNode node = stack.pop();
            int result = node.val;
            node = isPrev ? node.right : node.left;
            while (node != null) {
                stack.push(node);
                node = isPrev ? node.left : node.right;
            }
            return result;
        }

        public int peek() {
            return stack.peek().val;
        }

        private boolean isPrev;
        private Stack<TreeNode> stack = new Stack<>();
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Iterator prevIterator = new Iterator(root, target, true);
        Iterator nextIterator = new Iterator(root, target, false);
        List<Integer> result = new LinkedList<>();
        while (k-- > 0) {
            if (!prevIterator.hasNext()) {
                result.add(nextIterator.next());
            } else if (!nextIterator.hasNext()) {
                result.add(prevIterator.next());
            } else if (Math.abs(target - prevIterator.peek()) < Math.abs(target - nextIterator.peek())) {
                result.add(prevIterator.next());
            } else {
                result.add(nextIterator.next());
            }
        }
        return result;
    }

}
