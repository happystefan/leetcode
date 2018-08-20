package archive.Q001_Q300;

public class Q208_Implement_Trie_Prefix_Tree {

    class Node {
        Node[] child;
        boolean is_word;
        public Node(boolean is_word) {
            child = new Node[26];
            this.is_word = is_word;
        }

    }

    class Trie {
        Node root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new Node(false);
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node p = root;
            for (char c : word.toCharArray()) {
                if (p.child[c-'a'] == null) p.child[c-'a'] = new Node(false);
                p = p.child[c-'a'];
            }
            p.is_word = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node p = root;
            for (char c : word.toCharArray()) {
                if (p.child[c-'a'] == null) return false;
                p = p.child[c-'a'];
            }
            return p.is_word;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node p = root;
            for (char c : prefix.toCharArray()) {
                if (p.child[c-'a'] == null) return false;
                p = p.child[c-'a'];
            }
            return true;
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
