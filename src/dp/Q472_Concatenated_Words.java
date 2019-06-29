package dp;

import java.util.LinkedList;
import java.util.List;

public class Q472_Concatenated_Words {

    TrieNode root = new TrieNode();

    private void add(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.next[c - 'a'] == null) {
                curr.next[c - 'a'] = new TrieNode();
            }
            curr = curr.next[c - 'a'];
        }
        curr.isWord = true;
    }

    private boolean search(String word, int pos, int cnt) {
        if (pos == word.length() && cnt >= 2) {
            return true;
        }
        TrieNode curr = root;
        for (int i = pos; i < word.length(); i++) {
            if (curr.next[word.charAt(i) - 'a'] == null) {
                return false;
            }
            curr = curr.next[word.charAt(i) - 'a'];
            if (curr.isWord && search(word, i + 1, cnt + 1)) {
                return true;
            }
        }
        return false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        for (String word : words) {
            add(word);
        }
        List<String> result = new LinkedList<>();
        for (String word : words) {
            if (search(word, 0, 0)) {
                result.add(word);
            }
        }
        return result;
    }

    class TrieNode {
        TrieNode[] next;
        boolean isWord;

        public TrieNode() {
            next = new TrieNode[26];
        }
    }

}
