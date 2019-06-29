package Y2018.tree;

import java.util.Scanner;

public class Q449_Serialize_and_Deserialize_BST {

    // Encodes a archive.tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return String.valueOf(root.val) + " " + serialize(root.left) + " " + serialize(root.right);
    }

    // Decodes your encoded data to archive.tree.
    public TreeNode deserialize(String data) {
        return build(new Scanner(data));
    }

    private TreeNode build(Scanner sc) {
        if (!sc.hasNext()) {
            return null;
        }
        String token = sc.next();
        if (token.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(token));
        root.left = build(sc);
        root.right = build(sc);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
