package Y2020.facebook;

import java.util.Scanner;

public class Q0297_Serialize_and_Deserialize_Binary_Tree {


    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "#";
            else return root.val + " " + serialize(root.left) + " " + serialize(root.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return build(new Scanner(data));
        }

        private TreeNode build(Scanner sc) {
            if (!sc.hasNext()) return null;
            String token = sc.next();
            if (token.equals("#")) return null;
            TreeNode root = new TreeNode(Integer.valueOf(token));
            root.left = build(sc);
            root.right = build(sc);
            return root;
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.deserialize(codec.serialize(root));

}
