package archive.facebook;

import java.util.*;

public class Q745_Prefix_and_Suffix_Search {

    class WordFilter {
        class TrieNode {
            TrieNode[] next = new TrieNode[26];
            Integer idx;
        }

        private void insert(TrieNode root, int idx, String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.next[c - 'a'] == null) {
                    curr.next[c - 'a'] = new TrieNode();
                }
                curr = curr.next[c - 'a'];
            }
            curr.idx = idx;
        }

        private Set<Integer> search(TrieNode root, String str) {
            Set<Integer> result = new HashSet<>();
            TrieNode curr = root;
            for (char c : str.toCharArray()) {
                if (curr.next[c - 'a'] != null) {
                    curr = curr.next[c - 'a'];
                } else {
                    return result;
                }
            }
            dfs(result, curr);
            return result;
        }

        private void dfs(Set<Integer> result, TrieNode root) {
            if (root == null) {
                return;
            }
            if (root.idx != null) {
                result.add(root.idx);
            }
            for (TrieNode next : root.next) {
                dfs(result, next);
            }
        }

        TrieNode prefix_tree = new TrieNode();
        TrieNode suffix_tree = new TrieNode();
        public WordFilter(String[] words) {
            for (int i = 0; i < words.length; i++) {
                insert(prefix_tree, i, words[i]);
                insert(suffix_tree, i, new StringBuilder(words[i]).reverse().toString());
            }
        }

        public int f(String prefix, String suffix) {
            Set<Integer> a = search(prefix_tree, prefix);
            Set<Integer> b = search(suffix_tree, new StringBuilder(suffix).reverse().toString());
            a.retainAll(b);
            return a.isEmpty() ? -1 : a.stream().mapToInt(Integer::intValue).max().getAsInt();
        }
    }

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
}
