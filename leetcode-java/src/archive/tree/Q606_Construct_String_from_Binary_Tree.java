package archive.tree;

public class Q606_Construct_String_from_Binary_Tree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        String result = String.valueOf(t.val);
        if (t.left == null && t.right == null) {
            return result;
        }
        result += "(" + tree2str(t.left) + ")";
        if (t.right!= null) {
            result += "(" + tree2str(t.right) + ")";
        }
        return result;
    }

}
