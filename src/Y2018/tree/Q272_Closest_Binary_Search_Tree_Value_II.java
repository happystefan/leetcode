package Y2018.tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class Q272_Closest_Binary_Search_Tree_Value_II {

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        ArrayDeque<TreeNode> succStack = new ArrayDeque<>();
        ArrayDeque<TreeNode> prevSatck = new ArrayDeque<>();
        buildStack(succStack, root, target, true);
        buildStack(prevSatck, root, target, false);

        List<Integer> result = new LinkedList<>();
        while (k-- > 0) {
            if (succStack.isEmpty()) {
                result.add(prevSatck.peek().val);
                stackNext(prevSatck, false);
            } else if (prevSatck.isEmpty()) {
                result.add(succStack.peek().val);
                stackNext(succStack, true);
            } else {
                if (Math.abs(prevSatck.peek().val - target) > Math.abs(succStack.peek().val - target)) {
                    result.add(succStack.peek().val);
                    stackNext(succStack, true);
                } else {
                    result.add(prevSatck.peek().val);
                    stackNext(prevSatck, false);
                }
            }
        }
        return result;
    }

    private void buildStack(ArrayDeque<TreeNode> stack, TreeNode root, double target, boolean isSucc) {
        while (root != null) {
            if (root.val > target) {
                if (isSucc) {
                    stack.push(root);
                }
                root = root.left;
            } else {
                if (!isSucc) {
                    stack.push(root);
                }
                root = root.right;
            }
        }
    }

    private void stackNext(ArrayDeque<TreeNode> stack, boolean isSucc) {
        TreeNode node = stack.pop();
        node = (isSucc) ? node.right : node.left;
        while (node != null) {
            stack.push(node);
            node = (isSucc) ? node.left : node.right;
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
