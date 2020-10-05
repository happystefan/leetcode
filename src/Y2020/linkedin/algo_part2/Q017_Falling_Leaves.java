package Y2020.linkedin.algo_part2;

import java.util.*;


public class Q017_Falling_Leaves {


    List<Set<TreeNode>> fallingLeaves(TreeNode root) {
        List<Set<TreeNode>> rslt = new ArrayList<>();
        dfs(rslt, root);
        return rslt;
    }

    private int dfs( List<Set<TreeNode>> rslt, TreeNode root) {
        if (root == null) return -1;
        int level = 0;
        for (TreeNode c : root.children()) {
            level = Math.max(level, dfs(rslt, c) + 1);
        }
        if (rslt.size() <= level) rslt.add(new HashSet<>());
        rslt.get(level).add(root);
        return level;
    }

    interface TreeNode {
        Collection<TreeNode> children();
    }

}
