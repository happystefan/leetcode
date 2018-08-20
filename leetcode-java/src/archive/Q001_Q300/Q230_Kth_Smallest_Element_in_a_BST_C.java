package archive.Q001_Q300;

public class Q230_Kth_Smallest_Element_in_a_BST_C {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int ans = 0, cnt = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }

    public void dfs(TreeNode root, int k) {
        if (root == null) return;
        dfs(root.left, k);
        cnt++;
        if (cnt == k) { ans = root.val; return; }
        dfs(root.right, k);
    }

}
