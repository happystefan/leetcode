package Y2019.Q0001_Q0300;

import java.util.*;

public class Q0095_Unique_Binary_Search_Trees_II {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int lo, int hi) {
        List<TreeNode> result = new LinkedList<>();
        if (lo > hi) {
            result.add(null);
            return result;
        }
        if (lo == hi) {
            result.add(new TreeNode(lo));
            return result;
        }
        for (int i = lo; i <= hi; i++) {
            List<TreeNode> ll = generateTrees(lo, i - 1);
            List<TreeNode> rr = generateTrees(i + 1, hi);
            for (TreeNode l : ll) {
                for (TreeNode r : rr) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    result.add(root);
                }
            }
        }
        return result;
    }

}
