package facebook.backtracking;

import java.util.LinkedList;
import java.util.List;

public class Q212_Word_Search_II {

    TrieNode root = new TrieNode();
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new LinkedList<>();
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return result;
        }
        for (String word : words) insert(word);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(result, root, board, i, j);
            }
        }
        return result;
    }

    private void dfs(List<String> result, TrieNode root, char[][] board, int i, int j) {
        if (root == null) return;
        char c = board[i][j];
        root = root.next[c - 'a'];
        if (root != null && root.word != null) {
            result.add(root.word);
            root.word = null;
        }
        board[i][j] = '#';
        for (int[] dir : dirs) {
            int ii = i + dir[0], jj = j + dir[1];
            if (ii < 0 || ii >= board.length || jj < 0 || jj >= board[0].length) continue;
            if (board[ii][jj] == '#') continue;
            dfs(result, root, board, ii, jj);
        }
        board[i][j] = c;
    }

    private void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.next[c - 'a'] == null) curr.next[c - 'a'] = new TrieNode();
            curr = curr.next[c - 'a'];
        }
        curr.word = word;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

}
