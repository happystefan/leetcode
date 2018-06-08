package tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q250_Count_Univalue_Subtrees {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int countUnivalSubtrees(TreeNode root) {
        Map<TreeNode, Boolean> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        map.put(null, true);
        if (root != null) {
            stack.push(root);
        }
        int result = 0;
        while (!stack.isEmpty()) {
            root = stack.peek();
            if (map.containsKey(root.left) && map.containsKey(root.right)) {
                map.put(root, (root.left == null || map.get(root.left) && root.val == root.left.val) &&
                        (root.right == null || map.get(root.right) && root.val == root.right.val));
                if (map.get(root)) {
                    result++;
                }
                stack.pop();
            } else {
                if (root.left != null) {
                    stack.push(root.left);
                }
                if (root.right != null) {
                    stack.push(root.right);
                }

            }
        }
        return result;
    }

}

