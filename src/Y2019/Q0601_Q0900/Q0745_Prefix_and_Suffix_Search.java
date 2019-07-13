package Y2019.Q0601_Q0900;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Q0745_Prefix_and_Suffix_Search {

    class WordFilter {

        TrieNode prefix_root = new TrieNode();
        TrieNode suffix_root = new TrieNode();

        public WordFilter(String[] words) {
            for (int i = 0; i < words.length; i++) {
                insert(prefix_root, words[i], i);
                insert(suffix_root, new StringBuilder(words[i]).reverse().toString(), i);
            }
        }

        private void insert(TrieNode root, String str, int idx) {
            TrieNode curr = root;
            for (char c : str.toCharArray()) {
                if (curr.children[c - 'a'] == null) curr.children[c - 'a'] = new TrieNode();
                curr = curr.children[c - 'a'];
            }
            curr.idx = idx;
        }

        private Set<Integer> search(TrieNode root, String str) {
            Set<Integer> set = new HashSet<>();
            TrieNode curr = root;
            for (char c : str.toCharArray()) {
                if (curr.children[c - 'a'] == null) return set;
                curr = curr.children[c - 'a'];
            }
            dfs(set, curr);
            return set;
        }

        private void dfs(Set<Integer> set, TrieNode root) {
            if (root == null) return;
            if (root.idx != -1) set.add(root.idx);
            for (TrieNode child : root.children) dfs(set, child);
        }

        public int f(String prefix, String suffix) {
            Set<Integer> a = search(prefix_root, prefix);
            Set<Integer> b = search(suffix_root, new StringBuilder(suffix).reverse().toString());
            a.retainAll(b);
            return a.isEmpty() ? -1 : Collections.max(a);
        }

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            int idx;

            public TrieNode() {
                idx = -1;
            }
        }

    }

}
