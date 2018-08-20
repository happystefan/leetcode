package archive.graph;

import java.util.*;

public class Q444_Sequence_Reconstruction {

    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int n = org.length;
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (List<Integer> pair : new HashSet<>(seqs)) {
            if (pair.size() == 0) {
                continue;
            }
            int a = pair.get(0);
            graph.computeIfAbsent(a, k -> new HashSet<>());
            for (int i = 1; i < pair.size(); i++) {
                int b = pair.get(i);
                graph.get(a).add(b);
                a = b;
                graph.computeIfAbsent(a, k -> new HashSet<>());
            }
        }
        Map<Integer, Integer> degree = new HashMap<>();
        for (int i : graph.keySet()) {
            degree.computeIfAbsent(i, k -> 0);
            for (int j : graph.get(i)) {
                degree.put(j, degree.getOrDefault(j, 0)+1);
            }
        }
        Queue<Integer> Q = new LinkedList<>();
        for (int i : degree.keySet()) {
            if (degree.getOrDefault(i, 0) == 0) {
                Q.offer(i);
            }
        }
        if (Q.size() != 1) {
            return false;
        }

        List<Integer> order = new LinkedList<>();
        while (!Q.isEmpty()) {
            if (Q.size() != 1) {
                return false;
            }
            int c = Q.poll();
            order.add(c);
            if (graph.get(c) == null) {
                continue;
            }
            for (int i : graph.get(c)) {
                degree.put(i, degree.getOrDefault(i, 0)-1);
                if (degree.get(i) == 0) {
                    Q.offer(i);
                }
            }
        }

        if (order.size() != n) {
            return false;
        }
        int k = 0;
        for (int i : order) {
            if (i != org[k++]) {
                return false;
            }
        }

        return n == degree.size();
    }

}
