package Y2019.Q0001_Q0300;

import java.util.*;

public class Q0135_Candy {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: topological sort
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution1 {

        public int candy(int[] ratings) {
            if (ratings == null || ratings.length == 0) return 0;
            int n = ratings.length;
            Map<Integer, Set<Integer>> map = new HashMap<>();
            int[] degree = new int[n];
            for (int i = 0; i < n; i++) {
                if (i > 0 && ratings[i] < ratings[i - 1]) {
                    map.computeIfAbsent(i, k -> new HashSet<>()).add(i - 1);
                    degree[i - 1]++;
                }
                if (i < n - 1 && ratings[i] < ratings[i + 1]) {
                    map.computeIfAbsent(i, k -> new HashSet<>()).add(i + 1);
                    degree[i + 1]++;
                }
            }
            Queue<Integer> Q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (degree[i] == 0) Q.add(i);
            }
            int result = 0;
            int candy = 1;
            while (!Q.isEmpty()) {
                int size = Q.size();
                result += candy * size;
                candy++;
                while (size-- > 0) {
                    int curr = Q.poll();
                    for (int next : map.getOrDefault(curr, new HashSet<>())) {
                        degree[next]--;
                        if (degree[next] == 0) Q.add(next);
                    }
                }
            }
            return result;
        }

    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: two array
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution2 {

        public int candy(int[] ratings) {
            if (ratings == null || ratings.length == 0) return 0;
            int n = ratings.length;
            int[] l = new int[n];
            int[] r = new int[n];
            Arrays.fill(l, 1);
            Arrays.fill(r, 1);
            for (int i = 1; i < n; i++) {
                if (ratings[i] > ratings[i - 1]) l[i] = l[i - 1] + 1;
            }
            for (int i = n - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) r[i] = r[i + 1] + 1;
            }
            int sum = 0;
            for (int i = 0; i < n; i++) sum += Math.max(l[i], r[i]);
            return sum;
        }

    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 3: one array
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution3 {

        public int candy(int[] ratings) {
            if (ratings == null || ratings.length == 0) return 0;
            int n = ratings.length;
            int[] candy = new int[n];
            Arrays.fill(candy, 1);
            for (int i = 1; i < n; i++) {
                if (ratings[i] > ratings[i - 1]) candy[i] = candy[i - 1] + 1;
            }
            for (int i = n - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
            return Arrays.stream(candy).sum();
        }

    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 4: one pass with O(1) space
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution4 {

        public int candy(int[] ratings) {
            if (ratings == null || ratings.length == 0) return 0;
            int up = 0, down = 0, peak = 0;
            int result = 1;
            for (int i = 1; i < ratings.length; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    peak = ++up;
                    down = 0;
                    result += 1 + up;
                }
                if (ratings[i] == ratings[i - 1]) {
                    peak = up = down = 0;
                    result += 1;
                }
                if (ratings[i] < ratings[i - 1]) {
                    up = 0;
                    down++;
                    result += 1 + down;
                    if (peak >= down) result -= 1;
                }
            }
            return result;
        }

    }

}
