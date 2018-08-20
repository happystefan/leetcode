package archive.linkedin;

import java.util.Stack;

public class Q653_Two_Sum_IV_Input_is_a_BST_B {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Stack<TreeNode> stacka = new Stack<>();
    Stack<TreeNode> stackb = new Stack<>();
    TreeNode roota;
    TreeNode rootb;

    public boolean findTarget(TreeNode root, int k) {
        roota = root;
        rootb = root;
        TreeNode l = LeftMostChild();
        TreeNode r = RightMostChild();
        while (l.val < r.val) {
            if (l.val+r.val < k) {
                l = LeftMostChild();
            } else if (l.val+r.val > k) {
                r = RightMostChild();
            } else {
                return true;
            }
        }
        return false;
    }

    private TreeNode LeftMostChild() {
        while (roota != null) {
            stacka.push(roota);
            roota = roota.left;
        }
        TreeNode result = stacka.pop();
        roota = result.right;
        return result;
    }

    private TreeNode RightMostChild() {
        while (rootb != null) {
            stackb.push(rootb);
            rootb = rootb.right;
        }
        TreeNode result = stackb.pop();
        rootb = result.left;
        return result;
    }

}
