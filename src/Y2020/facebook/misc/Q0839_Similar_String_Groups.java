package Y2020.facebook.misc;

import java.util.*;

public class Q0839_Similar_String_Groups {

    class solution_dfs {

        public int numSimilarGroups(String[] A) {
            Map<String, Set<String>> map = new HashMap<>();
            for (int i = 0; i < A.length; i++) {
                for (int j = i + 1; j < A.length; j++) {
                    map.computeIfAbsent(A[i], k -> new HashSet<>());
                    map.computeIfAbsent(A[j], k -> new HashSet<>());
                    if (!isSimiliar(A[i], A[j])) continue;
                    map.get(A[i]).add(A[j]);
                    map.get(A[j]).add(A[i]);
                }
            }
            Set<String> visited = new HashSet<>();
            int rslt = 0;
            for (int i = 0; i < A.length; i++) {
                if (visited.contains(A[i])) continue;
                visited.add(A[i]);
                dfs(map, visited, A[i]);
                rslt++;
            }
            return rslt;
        }

        private void dfs(Map<String, Set<String>> map, Set<String> visited, String cur) {
            for (String nxt : map.getOrDefault(cur, new HashSet<>())) {
                if (visited.contains(nxt)) continue;
                visited.add(nxt);
                dfs(map, visited, nxt);
            }
        }

        private boolean isSimiliar(String a, String b) {
            if (a.length() != b.length()) return false;
            int cnt = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) cnt++;
                if (cnt > 2) return false;
            }
            return cnt <= 2;
        }

    }

    class solution_union_find {

        public int numSimilarGroups(String[] A) {
            int[] p = new int[A.length];
            // Arrays.fill(p, -1);
            for (int i = 0; i < p.length; i++) {
                p[i] = i;
            }
            for (int i = 0; i < A.length; i++) {
                for (int j = i + 1; j < A.length; j++) {
                    if (!isSimiliar(A[i], A[j])) continue;
                    int pi = findp(p, i);
                    int pj = findp(p, j);
                    p[pj] = pi;
                }
            }
            Set<Integer> pset = new HashSet<>();
            for (int i = 0; i < A.length; i++) {
                pset.add(findp(p, i));
            }
            return pset.size();
        }

        private int findp(int[] p, int i) {
            if (p[i] == i) return i;
            p[i] = findp(p, p[i]);
            return p[i];
        }

        private boolean isSimiliar(String a, String b) {
            if (a.length() != b.length()) return false;
            int cnt = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) cnt++;
                if (cnt > 2) return false;
            }
            return cnt <= 2;
        }


    }
}
