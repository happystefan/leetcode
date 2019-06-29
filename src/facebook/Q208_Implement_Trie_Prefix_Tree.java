package facebook;

public class Q208_Implement_Trie_Prefix_Tree {

    class Trie {

        /**
         * Initialize your data structure here.
         */
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.next[c - 'a'] == null) curr.next[c - 'a'] = new TrieNode();
                curr = curr.next[c - 'a'];
            }
            curr.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.next[c - 'a'] == null) {
                    return false;
                }
                curr = curr.next[c - 'a'];
            }
            return curr.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode curr = root;
            for (char c : prefix.toCharArray()) {
                if (curr.next[c - 'a'] == null) {
                    return false;
                }
                curr = curr.next[c - 'a'];
            }
            return true;
        }
    }

    class TrieNode {
        char c;
        TrieNode[] next = new TrieNode[26];
        boolean isWord;
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

}
