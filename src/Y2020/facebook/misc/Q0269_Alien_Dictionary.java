package Y2020.facebook.misc;

import java.util.*;

public class Q0269_Alien_Dictionary {

    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        for (String word : words) { // NOTE: this for-loop is important, can not been removed
            for (char c : word.toCharArray()) degree.put(c, 0);
        }
        for (int i = 1; i < words.length; i++) {
            String a = words[i - 1], b = words[i];
            if (a.equals(b)) continue;
            if (a.startsWith(b)) return ""; // input is invalid
            if (b.startsWith(a)) continue;
            int j = 0;
            while (a.charAt(j) == b.charAt(j)) j++;
            char u = a.charAt(j), v = b.charAt(j);
            // NOTE: this if-statement is important, can not been removed
            if (map.containsKey(u) && map.get(u).contains(v)) continue;
            map.computeIfAbsent(u, k -> new HashSet<>()).add(v);
            degree.put(v, degree.getOrDefault(v, 0) + 1);
        }
        Queue<Character> Q = new LinkedList<>();
        for (char c : degree.keySet()) {
            if (degree.get(c) == 0) Q.add(c);
        }
        StringBuilder rslt = new StringBuilder();
        while (!Q.isEmpty()) {
            char c = Q.poll();
            rslt.append(c);
            for (char next : map.getOrDefault(c, new HashSet<>())) {
                degree.put(next, degree.get(next) - 1);
                if (degree.get(next) == 0) Q.add(next);
            }
        }
        return rslt.length() == degree.size() ? rslt.toString() : "";
    }

}
