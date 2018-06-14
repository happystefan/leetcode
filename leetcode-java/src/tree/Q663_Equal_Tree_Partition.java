package tree;

import java.util.*;

public class Q663_Equal_Tree_Partition {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean checkEqualTree(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        int sum = treeSum(set, root);
        return sum%2 == 0 && set.contains(sum/2);
    }

    private int treeSum(Set<Integer> set, TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = 0, r = 0;
        if (root.left != null) {
            l = treeSum(set, root.left);
            set.add(l);
        }
        if (root.right != null) {
            r = treeSum(set, root.right);
            set.add(r);
        }

        return l+r+root.val;
    }

}
