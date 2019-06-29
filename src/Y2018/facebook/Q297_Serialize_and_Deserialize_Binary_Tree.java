package Y2018.facebook;

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

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "null";
            return root.val + " " + serialize(root.left) + " " + serialize(root.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return deserialize(new Scanner(data));
        }

        private TreeNode deserialize(Scanner sc) {
            if (!sc.hasNext()) return null;
            String token = sc.next();
            if (token.equals("null")) return null;
            TreeNode root = new TreeNode(Integer.valueOf(token));
            root.left = deserialize(sc);
            root.right = deserialize(sc);
            return root;
        }

    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

}
