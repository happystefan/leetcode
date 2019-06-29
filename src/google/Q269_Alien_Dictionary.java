package google;

import java.util.*;

public class Q269_Alien_Dictionary {

    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        Map<Character, Set<Character>> map = new HashMap<>();
        int[] degree = new int[26];
        int cnt = 0;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (degree[c - 'a'] == 0) {
                    cnt++;
                    degree[c - 'a'] = 1;
                }
            }
        }
        for (int i = 1; i < words.length; i++) {
            char[] a = words[i - 1].toCharArray(), b = words[i].toCharArray();
            for (int j = 0; j < Math.min(a.length, b.length); j++) {
                if (a[j] == b[j]) continue;
                if (!map.containsKey(a[j])) map.put(a[j], new HashSet<>());
                if (map.get(a[j]).add(b[j])) degree[b[j] - 'a']++;
                break;
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 1) queue.add((char) (i + 'a'));
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            if (!map.containsKey(c)) continue;
            for (char n : map.get(c)) {
                degree[n - 'a']--;
                if (degree[n - 'a'] == 1) queue.add(n);
            }
        }
        return sb.length() == cnt ? sb.toString() : "";
    }

}
