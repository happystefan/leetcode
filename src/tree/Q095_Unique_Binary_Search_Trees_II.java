package tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Q095_Unique_Binary_Search_Trees_II {

    public List<TreeNode> generateTrees(int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }
        return dfs(set);
    }

    private List<TreeNode> dfs(Set<Integer> set) {
        List<TreeNode> result = new LinkedList<>();
        for (int i : set) {
            Set<Integer> lset = new HashSet<>();
            Set<Integer> rset = new HashSet<>();
            for (int j : set) {
                if (i == j) {
                    continue;
                }
                if (j < i) {
                    lset.add(j);
                }
                if (j > i) {
                    rset.add(j);
                }
            }

            List<TreeNode> ls = dfs(lset);
            List<TreeNode> rs = dfs(rset);
            if (ls.size() == 0 && rs.size() == 0) {
                result.add(new TreeNode(i));
                return result;
            }
            if (ls.size() == 0) {
                for (TreeNode r : rs) {
                    TreeNode root = new TreeNode(i);
                    root.left = null;
                    root.right = r;
                    result.add(root);
                }
            }
            if (rs.size() == 0) {
                for (TreeNode l : ls) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = null;
                    result.add(root);
                }
            }

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
