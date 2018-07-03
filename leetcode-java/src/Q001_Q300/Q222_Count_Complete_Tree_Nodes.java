package Q001_Q300;

public class Q222_Count_Complete_Tree_Nodes {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int countNodes(TreeNode root) {
        int leftDepth = leftDepth(root), rightDepth = rightDepth(root);
        if (leftDepth == rightDepth) return (1<<leftDepth)-1;
        return countNodes(root.left)+countNodes(root.right);
    }

    public int leftDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }

    public int rightDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth++;
            root = root.right;
        }
        return depth;
    }

}
