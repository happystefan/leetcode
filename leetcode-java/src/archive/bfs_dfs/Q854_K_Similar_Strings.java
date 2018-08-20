package archive.bfs_dfs;

import java.util.*;

public class Q854_K_Similar_Strings {

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
                for (String nxt: next(cur)) {
                    if (!visited.contains(nxt)) {
                        Q.offer(nxt);
                    }
                }
            }

            result++;
        }
        return result;
    }

    private LinkedList<String> next(String str) {
        LinkedList<String> result = new LinkedList<>();
        char[] cc = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1; j < str.length(); j++) {

                swap(cc, i, j);
                result.add(new String(cc));
                swap(cc, i, j);
            }
        }


        /*
        char[] cc = str.toCharArray();
        for (int j = i+1; j < str.length(); j++) {
            if (str.charAt(j) == target.charAt(i)) {
                swap(cc, i, j);
                result.add(new String(cc));
                swap(cc, i, j);
            }
        }
        */
        return result;
    }

    private void swap(char[] cc, int i, int j) {
        char t = cc[i];
        cc[i] = cc[j];
        cc[j] = t;
    }

}
