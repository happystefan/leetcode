package Y2020.facebook.tree;

import java.util.*;

public class Q0272_Closest_Binary_Search_Tree_Value_II {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class solution_O_N {

        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            Deque<Integer> Q = new ArrayDeque<>();
            dfs(root, Q);
            while (Q.size() > k) {
                if (Math.abs(Q.peekFirst() - target) > Math.abs(Q.peekLast() - target)) {
                    Q.pollFirst();
                } else {
                    Q.pollLast();
                }
            }
            return new LinkedList<>(Q);
        }

        private void dfs(TreeNode root, Deque<Integer> Q) {
            if (root == null) return;
            dfs(root.left, Q);
            Q.add(root.val);
            dfs(root.right, Q);
        }

    }

    // Best: O(k); Worst: O(N)
    class solution_dfs_early_return {

        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            List<Integer> rslt = new LinkedList<>();
            dfs(rslt, root, target, k);
            return rslt;
        }

        private void dfs(List<Integer> rslt, TreeNode root, double target, int k) {
            if (root == null) return;
            dfs(rslt, root.left, target, k);

            if (rslt.size() == k) {
                if (Math.abs(root.val - target) < Math.abs(rslt.get(0) - target)) {
                    rslt.remove(0);
                } else {
                    return;
                }
            }
            rslt.add(root.val);

            dfs(rslt, root.right, target, k);
        }

    }

    // K*log(N)
    class solution_two_stack {

        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            List<Integer> rslt = new LinkedList<>();
            Stack<TreeNode> prevStack = new Stack<>();
            Stack<TreeNode> nextStack = new Stack<>();

            TreeNode curr = root;
            while (curr != null) {
                if (curr.val < target) {
                    prevStack.push(curr);
                    curr = curr.right;
                } else {
                    nextStack.push(curr);
                }
            }

            while (k-- > 0) {
                if (prevStack.isEmpty()) {
                    rslt.add(nextStack.peek().val);
                    pop(nextStack, false);
                } else if (nextStack.isEmpty()) {
                    rslt.add(prevStack.peek().val);
                    pop(prevStack, true);
                } else {
                    if (Math.abs(prevStack.peek().val-target) < Math.abs(nextStack.peek().val - target)) {
                        rslt.add(prevStack.peek().val);
                        pop(prevStack, true);
                    } else {
                        rslt.add(nextStack.peek().val);
                        pop(nextStack, false);
                    }
                }
            }
            return rslt;
        }

        private void pop(Stack<TreeNode> stack, boolean isPrev) {
            TreeNode node = stack.pop();
            node = isPrev ? node.left : node.right;
            while (node != null) {
                stack.push(node);
                node = isPrev ? node.right : node.left;
            }
        }


    }

}
