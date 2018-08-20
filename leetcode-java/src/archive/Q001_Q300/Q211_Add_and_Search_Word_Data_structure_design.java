package archive.Q001_Q300;

public class Q211_Add_and_Search_Word_Data_structure_design {

    class WordDictionary {

        class Node {
            Node[] children;
            boolean is_word;
            public Node(boolean is_word) {
                children = new Node[26];
                this.is_word = is_word;
            }
        }

        Node root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new Node(false);
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            Node p = root;
            for(char c : word.toCharArray()) {
                if(p.children[c-'a'] == null) p.children[c-'a'] = new Node(false);
                p = p.children[c-'a'];
            }
            p.is_word = true;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return search(root, word);
        }

        public boolean search(Node root, String word) {
            Node p = root;
            if (word.length() > 0) {
                if (root.children == null) return false;
                char c = word.charAt(0);
                if (c != '.') {
                    if(root.children[c-'a'] == null) return false;
                    return search(root.children[c-'a'], word.substring(1));
                } else {
                    boolean found = false;
                    for (int i = 0; i < 26; i++) {
                        if(root.children[i] != null) {
                            found |= search(root.children[i], word.substring(1));
                        }
                    }
                    return found;
                }
            }
            return root.is_word;
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

}
