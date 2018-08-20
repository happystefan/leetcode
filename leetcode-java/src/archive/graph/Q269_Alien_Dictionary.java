package archive.graph;

import java.util.*;

public class Q269_Alien_Dictionary {

    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                map.computeIfAbsent(c, k->new HashSet<>());
                degree.put(c, 0);
            }
        }
        for (int i = 1; i < words.length; i++) {
            String a = words[i-1], b = words[i];
            for (int j = 0; j < Math.min(a.length(), b.length()); j++) {
                char u = a.charAt(j), v = b.charAt(j);
                if (u == v) {
                    continue;
                }
                if (!map.get(u).contains(v)) { // NOTE: this if statement is important
                    map.get(u).add(v);
                    degree.put(v, degree.getOrDefault(v, 0) + 1);
                }
                break; // NOTE: this break statement is important
            }
        }

        Queue<Character> Q = new LinkedList<>();
        for (char c : degree.keySet()) {
            if (degree.get(c) == 0) {
                Q.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!Q.isEmpty()) {
            char u = Q.poll();
            sb.append(u);
            if (!map.containsKey(u)) {
                continue;
            }
            for (char v : map.get(u)) {
                degree.put(v, degree.get(v)-1);
                if (degree.get(v) == 0) {
                    Q.offer(v);
                }
            }
        }
        return sb.length() == degree.size() ? sb.toString() : "";
    }

}
