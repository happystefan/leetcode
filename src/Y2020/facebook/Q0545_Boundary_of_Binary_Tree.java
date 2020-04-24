package Y2020.facebook;

import java.util.LinkedList;
import java.util.List;

public class Q0545_Boundary_of_Binary_Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
       List<Integer> rslt = new LinkedList<>();
       if (root == null) return rslt;
       rslt.add(root.val);
       dfs(root.left, rslt, true, false);
       dfs(root.right, rslt, false, true);
       return rslt;
    }

    private void dfs(TreeNode root, List<Integer> rslt, boolean isLeft, boolean isRight) {
        if (root == null) return;
        if (isLeft) rslt.add(root.val);
        dfs(root.left, rslt, isLeft, isRight && root.right == null);
        if (!isLeft && !isRight && root.left == null && root.right == null) rslt.add(root.val);
        dfs(root.right, rslt, isLeft && root.left == null, isRight);
        if (isRight) rslt.add(root.val);
    }

}
