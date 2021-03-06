package Y2018.google;

import java.util.Scanner;

public class Q297_Serialize_and_Deserialize_Binary_Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {

        // Encodes a archive.tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "#";
            return "" + root.val + " " + serialize(root.left) + " " + serialize(root.right);
        }

        // Decodes your encoded data to archive.tree.
        public TreeNode deserialize(String data) {
            return build(new Scanner(data));
        }

        private TreeNode build(Scanner sc) {
            if (!sc.hasNext()) return null;
            String tk = sc.next();
            if (tk.equals("#")) return null;
            TreeNode root = new TreeNode(Integer.parseInt(tk));
            root.left = build(sc);
            root.right = build(sc);
            return root;
        }

    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

}
