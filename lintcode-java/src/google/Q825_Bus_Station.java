package google;


import java.util.*;

public class Q825_Bus_Station {

    public int getMinTransferNumber(int N, int[][] route, int A, int B) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for (int[] r : route) {
            for (int i : r) {
                map.computeIfAbsent(i, k -> new HashSet<>());
                for (int j : r) {
                    if (i == j) continue;
                    map.get(i).add(j);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(A);
        visited.add(A);
        int ans = 0;

        while (!queue.isEmpty()) {
            int qsize = queue.size();

            for (int i = 0; i < qsize; i++) {
                int c = queue.poll();
                visited.add(c);
                if (c == B) return ans;

                Set<Integer> nxt = map.get(c);
                for (int j : nxt) {
                    if (visited.contains(j)) continue;
                    queue.add(j);
                }
            }
            ans++;
        }
        return -1;
    }

}

