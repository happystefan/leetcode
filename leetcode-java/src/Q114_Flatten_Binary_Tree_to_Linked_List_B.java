import java.util.Stack;

public class Q114_Flatten_Binary_Tree_to_Linked_List_B {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void flatten(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) stack.add(cur.right);
            if (cur.left != null) stack.add(cur.left);
            cur.left = null;
            if (!stack.isEmpty()) cur.right = stack.peek();
        }
    }

}
