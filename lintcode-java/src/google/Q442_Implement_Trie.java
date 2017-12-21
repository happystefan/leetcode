package google;

/**
 * Created by mingqiangliang on 12/21/17.
 */
public class Q442_Implement_Trie {

    public class Trie {

        public class Node {
            Node[] child = new Node[26];
            boolean isEnd;
            Node(boolean isEnd) {
                this.isEnd = isEnd;
            }
        }

        private Node root;

        public Trie() {
            // do intialization if necessary
            root = new Node(false);
        }

        /*
         * @param word: a word
         * @return: nothing
         */
        public void insert(String word) {
            // write your code here
            Node cur = root;
            for (char c : word.toCharArray()) {
                if (cur.child[c-'a'] == null) cur.child[c-'a'] = new Node(false);
                cur = cur.child[c-'a'];
            }
            cur.isEnd = true;
        }

        /*
         * @param word: A string
         * @return: if the word is in the trie.
         */
        public boolean search(String word) {
            // write your code here
            Node cur = root;
            for (char c : word.toCharArray()) {
                if (cur.child[c-'a'] == null) return false;
                cur = cur.child[c-'a'];
            }
            return cur.isEnd;
        }

        /*
         * @param prefix: A string
         * @return: if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            // write your code here
            Node cur = root;
            for (char c : prefix.toCharArray()) {
                if (cur.child[c-'a'] == null) return false;
                cur = cur.child[c-'a'];
            }
            return true;
        }
    }

}
