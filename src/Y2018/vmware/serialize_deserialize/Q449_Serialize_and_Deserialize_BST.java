package Y2018.vmware.serialize_deserialize;

public class Q449_Serialize_and_Deserialize_BST {

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
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        private void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) return;
            sb.append(root.val);
            if (root.left != null) {
                sb.append(" ");
                serialize(root.left, sb);
            }
            if (root.right != null) {
                sb.append(" ");
                serialize(root.right, sb);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.isEmpty()) return null;
            String[] tokens = data.split(" ");
            return deserialize(tokens, 0, tokens.length - 1);
        }

        private TreeNode deserialize(String[] tokens, int l, int r) {
            if (l > r) return null;
            int val = Integer.valueOf(tokens[l]);
            TreeNode root = new TreeNode(val);
            int i = 0;
            for (i = l + 1; i <= r; i++) {
                if (Integer.valueOf(tokens[i]) > val) {
                    break;
                }
            }
            root.left = deserialize(tokens, l + 1, i - 1);
            root.right = deserialize(tokens, i, r);
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

}
