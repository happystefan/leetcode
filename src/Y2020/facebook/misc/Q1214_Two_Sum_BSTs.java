package Y2020.facebook.misc;

import java.util.ArrayList;
import java.util.List;

public class Q1214_Two_Sum_BSTs {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        for (int num : list1) {
            if (bsearch(list2, target - num)) return true;
        }
        return false;
    }

    private boolean bsearch(List<Integer> list, int target) {
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (list.get(m) < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return list.get(l) == target ? true : false;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

}
