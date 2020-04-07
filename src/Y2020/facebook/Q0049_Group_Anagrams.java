package Y2020.facebook;

import java.util.*;

public class Q0049_Group_Anagrams {

    class solution_sort {

        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                map.computeIfAbsent(root(str), k -> new LinkedList<>()).add(str);
            }
            return new LinkedList<>(map.values());
        }

        private String root(String str) {
            char[] ss = str.toCharArray();
            Arrays.sort(ss);
            return new String(ss);
        }

    }

    class solution_count {

        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                map.computeIfAbsent(root(str), k -> new LinkedList<>()).add(str);
            }
            return new LinkedList<>(map.values());
        }

        private String root(String str) {
            int[] cnt = new int[26];
            for (char c : str.toCharArray()) cnt[c - 'a']++;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cnt.length; i++) {
                sb.append(cnt[i]).append("#");
            }
            return sb.toString();
        }

    }

}
