package google;

public class Q208_Implement_Trie_Prefix_Tree {

    class Trie {

        Node root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new Node('0', false);
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Node p = root;
            for (char c : word.toCharArray()) {
                if (p.child[c - 'a'] == null) p.child[c - 'a'] = new Node(c, false);
                p = p.child[c - 'a'];
            }
            p.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Node p = root;
            for (char c : word.toCharArray()) {
                if (p.child[c - 'a'] == null) return false;
                p = p.child[c - 'a'];
            }
            return p.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Node p = root;
            for (char c : prefix.toCharArray()) {
                if (p.child[c - 'a'] == null) return false;
                p = p.child[c - 'a'];
            }
            return true;
        }

        class Node {
            char value;
            Node[] child = new Node[26];
            boolean isEnd = false;

            public Node(char value, boolean isEnd) {
                this.value = value;
                this.isEnd = isEnd;
            }
        }

    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

}
