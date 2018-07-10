package bfs_dfs;

import java.util.*;

public class Q425_Word_Squares_C {

    // DFS + TrieTree for prefix->word look-up
    TrieNode root = new TrieNode();
    public List<List<String>> wordSquares(String[] words) {
        // build TrieTree fot prefix-word look -up
        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.next[c-'a'] == null) {
                    curr.next[c-'a'] = new TrieNode();
                }
                curr = curr.next[c-'a'];
            }
            curr.word = word;
        }
        List<List<String>> result = new LinkedList<>();
        dfs(result, words, new LinkedList<>());
        return result;
    }

    private void dfs(List<List<String>> result, String[] words, List<String> list) {
        if (list.size() == words[0].length()) {
            result.add(new LinkedList<>(list));
            return;
        }
        String prefix = "";
        int n = list.size();
        for (int i = 0; i < n; i++) {
            prefix += list.get(i).charAt(n);
        }
        for (String word : wordsWithPrefix(prefix)) {
            list.add(word);
            dfs(result, words, list);
            list.remove(list.size()-1);
        }
    }

    private List<String> wordsWithPrefix(String prefix) {
        TrieNode curr = root;
        List<String> result = new LinkedList<>();
        for (char c : prefix.toCharArray()) {
            curr = curr.next[c-'a'];
            if (curr == null) {
                break;
            }
        }
        down(curr, result);
        return result;
    }

    private void down(TrieNode curr, List<String> result) {
        if (curr == null) {
            return;
        }
        if (curr.word != null) {
            result.add(curr.word);
            return;
        }
        for (int i = 0; i < curr.next.length; i++) {
            down(curr.next[i], result);
        }
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

}
