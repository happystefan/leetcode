package Y2020.facebook;

public class Q0211_Add_and_Search_Word_Data_structure_design {

    class WordDictionary {

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean end;
        }

        TrieNode root = new TrieNode();

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) curr.children[c - 'a'] = new TrieNode();
                curr = curr.children[c - 'a'];
            }
            curr.end = true;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            TrieNode curr = root;
            return dfs(curr, word, 0);
        }

        private boolean dfs(TrieNode root, String word, int pos) {
            if (root == null) return false;
            if (pos == word.length()) return root.end;
            if (word.charAt(pos) != '.') {
                root = root.children[word.charAt(pos) - 'a'];
                return dfs(root, word, pos + 1);
            } else {
                for (TrieNode child : root.children) {
                    if (dfs(child, word, pos + 1)) return true;
                }
            }
            return false;
        }

    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

}
