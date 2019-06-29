package Y2018.tree;

import java.util.LinkedList;
import java.util.List;

public class Q095_Unique_Binary_Search_Trees_II_B {
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int min, int max) {
        List<TreeNode> result = new LinkedList<>();
        if (min > max) {
            result.add(null);
            return result;
        }
        if (min == max) {
            result.add(new TreeNode(min));
            return result;
        }
        for (int i = min; i <= max; i++) {
            List<TreeNode> ls = generateTrees(min, i - 1);
            List<TreeNode> rs = generateTrees(i + 1, max);
            for (TreeNode l : ls) {
                for (TreeNode r : rs) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    result.add(root);
                }
            }
        }
        return result;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}

