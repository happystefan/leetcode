package Q100_Q199;

import java.util.ArrayList;
import java.util.List;

public class Q199_Binary_Tree_Right_Side_View_B {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        visit(ans, root, 0);
        return ans;
    }

    public void visit(ArrayList<Integer> ans, TreeNode root, int depth) {
        if (root == null) return;
        if (depth == ans.size()) ans.add(root.val);
        visit(ans, root.right, depth+1);
        visit(ans, root.left, depth+1);
    }

}
