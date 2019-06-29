package Y2018.bfs_dfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q854_K_Similar_Strings_B {

    // BFS: Memory Limit Exceeded
    public int kSimilarity(String A, String B) {
        Set<String> visited = new HashSet<>();
        Queue<String> Q = new LinkedList<>();
        Q.add(A);
        int result = 0;
        while (!Q.isEmpty()) {
            int size = Q.size();
            while (size-- > 0) {
                String cur = Q.poll();
                if (cur.equals(B)) {
                    return result;
                }
                visited.add(cur);
                for (String nxt : next(cur, B)) {
                    if (!visited.contains(nxt)) {
                        Q.offer(nxt);
                    }
                }
            }

            result++;
        }
        return result;
    }

    private LinkedList<String> next(String str, String target) {
        LinkedList<String> result = new LinkedList<>();
        int i = 0;
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) != target.charAt(i)) {
                break;
            }
        }
        char[] cc = str.toCharArray();
        for (int j = i + 1; j < str.length(); j++) {
            if (str.charAt(j) == target.charAt(i)) {
                swap(cc, i, j);
                result.add(new String(cc));
                swap(cc, i, j);
            }
        }
        return result;
    }

    private void swap(char[] cc, int i, int j) {
        char t = cc[i];
        cc[i] = cc[j];
        cc[j] = t;
    }

}
