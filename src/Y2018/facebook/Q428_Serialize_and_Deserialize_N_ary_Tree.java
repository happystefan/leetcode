package Y2018.facebook;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Q428_Serialize_and_Deserialize_N_ary_Tree {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Codec {
        // Encodes a tree to a single string.
        public String serialize(Node root) {
            StringBuilder sb = new StringBuilder();
            serialize(sb, root);
            return sb.toString();
        }

        private void serialize(StringBuilder sb, Node root) {
            if (root == null) {
                sb.append("null");
                return;
            }
            sb.append(root.val);
            sb.append(" ");
            sb.append(root.children.size());
            sb.append(" ");
            for (Node child : root.children) {
                serialize(sb, child);
                sb.append(" ");
            }
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            return deserialize(new Scanner(data));
        }

        private Node deserialize(Scanner sc) {
            if (!sc.hasNext()) return null;
            String token = sc.next();
            if (token.equals("null")) return null;
            int size = Integer.valueOf(sc.next());
            Node root = new Node(Integer.valueOf(token), new LinkedList<>());
            while (size-- > 0) {
                root.children.add(deserialize(sc));
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

}
