package facebook;

public class Q211_Add_and_Search_Word_Data_structure_design {

    class WordDictionary {

        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new TrieNode();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.next[c - 'a'] == null) {
                    curr.next[c - 'a'] = new TrieNode();
                }
                curr = curr.next[c - 'a'];
            }
            curr.word = word;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            TrieNode curr = root;
            return dfs(curr, word, 0);
        }

        private boolean dfs(TrieNode curr, String word, int pos) {
            if (curr == null) {
                return false;
            }
            if (pos == word.length()) {
                return curr.word != null;
            }
            if (word.charAt(pos) != '.') {
                return dfs(curr.next[word.charAt(pos) - 'a'], word, pos + 1);
            } else {
                for (TrieNode next : curr.next) {
                    if (next == null) {
                        continue;
                    }
                    if (dfs(next, word, pos + 1)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

}
