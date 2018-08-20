package archive.tree;

import java.util.Stack;

public class Q536_Construct_Binary_Tree_from_String {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode str2tree(String s) {
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                stack.pop();
            } else if (c == '-' || Character.isDigit(c)) {
                int j = i;
                while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    i++;
                }
                TreeNode curr = new TreeNode(Integer.valueOf(s.substring(j, i+1)));
                if (!stack.isEmpty()) {
                    TreeNode parent = stack.peek();
                    if (parent.left != null) {
                        parent.right = curr;
                    } else {
                        parent.left = curr;
                    }
                }
                stack.push(curr);
            }
        }
        return stack.isEmpty() ? null : stack.peek();
    }

}
