package Y2018.tree;

public class Q222_Count_Complete_Tree_Nodes {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = 0, rh = 0;
        TreeNode l = root, r = root;
        while (l != null) {
            lh++;
            l = l.left;
        }
        while (r != null) {
            rh++;
            r = r.right;
        }
        if (lh == rh) {
            return (1 << lh) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
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
