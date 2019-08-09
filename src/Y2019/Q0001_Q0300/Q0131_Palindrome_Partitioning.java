package Y2019.Q0001_Q0300;

import java.util.LinkedList;
import java.util.List;

public class Q0131_Palindrome_Partitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        if (s == null || s.isEmpty()) return result;
        char[] ss = s.toCharArray();
        int n = ss.length;
        boolean[][] isPalindrome = new boolean[n][n];
        {
            for (int k = 0; k < n; k++) {
                isPalindrome[k][k] = true;
                int i = k - 1, j = k + 1;
                while (i >= 0 && j < n && ss[i] == ss[j] && isPalindrome[i + 1][j - 1]) {
                    isPalindrome[i][j] = true;
                    i--;
                    j++;
                }
            }
            for (int k = 1; k < n; k++) {
                if (ss[k - 1] != ss[k]) continue;
                isPalindrome[k - 1][k] = true;
                int i = k - 2, j = k + 1;
                while (i >= 0 && j < n && ss[i] == ss[j] && isPalindrome[i + 1][j - 1]) {
                    isPalindrome[i][j] = true;
                    i--;
                    j++;
                }
            }
        }
        {   // version 2
            for (int i = 0; i < n; i++) isPalindrome[i][i] = true;
            for (int i = 1; i < n; i++) isPalindrome[i - 1][i] = ss[i - 1] == ss[i];
            for (int l = 2; l < n; l++) {
                for (int i = 0; i + l < n; i++) {
                    int j = i + l;
                    isPalindrome[i][j] = ss[i] == ss[j] && isPalindrome[i + 1][j - 1];
                }
            }
        }
        dfs(result, new LinkedList<>(), isPalindrome, s, 0);
        return result;
    }

    private void dfs(List<List<String>> result, List<String> list, boolean[][] isPalindrome, String s, int pos) {
        if (pos == s.length()) {
            result.add(new LinkedList<>(list));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            if (!isPalindrome[pos][i]) continue;
            list.add(s.substring(pos, i + 1));
            dfs(result, list, isPalindrome, s, i + 1);
            list.remove(list.size() - 1);
        }
    }

}
