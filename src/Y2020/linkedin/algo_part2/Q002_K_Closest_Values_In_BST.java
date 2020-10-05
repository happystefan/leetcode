package Y2020.linkedin.algo_part2;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q002_K_Closest_Values_In_BST {

    // K*log(N) if tree is balance
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
                if (Math.abs(prevStack.peek().val - target) < Math.abs(nextStack.peek().val - target)) {
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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
