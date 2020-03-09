package Y2020.facebook;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Q0428_Serialize_and_Deserialize_N_ary_Tree {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Codec {

        // Encodes a tree to a single string.
        public String serialize(Node root) {
            if (root == null) return "#";
            String rslt = root.val + " " + root.children.size();
            for (Node child : root.children) {
                rslt += " " + serialize(child);
            }
            return rslt;
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            Scanner sc = new Scanner(data);
            return build(sc);
        }

        private Node build(Scanner sc) {
            if (!sc.hasNext()) return null;
            String val = sc.next();
            if (val.equals("#")) return null;
            Node root = new Node(Integer.valueOf(val), new LinkedList<>());
            int cnt = Integer.valueOf(sc.next());
            while (cnt-- > 0) {
                root.children.add(build(sc));
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

}
