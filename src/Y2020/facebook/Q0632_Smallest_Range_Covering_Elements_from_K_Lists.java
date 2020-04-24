package Y2020.facebook;

import java.util.*;

public class Q0632_Smallest_Range_Covering_Elements_from_K_Lists {

    class solution_sliding_window {

        public int[] smallestRange(List<List<Integer>> nums) {
            List<int[]> pairs = new ArrayList<>();
            for (int i = 0; i < nums.size(); i++) {
                List<Integer> list = nums.get(i);
                for (int num : list) {
                    pairs.add(new int[]{num, i});
                }
            }

            Collections.sort(pairs, (a, b) -> a[0] - b[0]);
            int k = nums.size();
            int l = 0, r = 0;
            Map<Integer, Integer> map = new HashMap<>();
            int[] rslt = new int[]{pairs.get(0)[0], pairs.get(pairs.size() - 1)[0]};

            while (r < pairs.size()) {
                int[] rg = pairs.get(r);
                map.put(rg[1], map.getOrDefault(rg[1], 0) + 1);
                r++;
                while (map.size() == k) {
                    int[] lg = pairs.get(l);
                    if (rg[0] - lg[0] < rslt[1] - rslt[0]) {
                        rslt[0] = rg[0];
                        rslt[1] = lg[0];
                    }
                    map.put(lg[1], map.get(lg[1]) - 1);
                    if (map.get(lg[1]) == 0) map.remove(lg[1]);
                    l++;
                }
            }
            return rslt;
        }

    }

    class solution_merge_k_sorted_list {

        public int[] smallestRange(List<List<Integer>> nums) {
            PriorityQueue<int[]> Q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.size(); i++) {
                int v = nums.get(i).get(0);
                Q.add(new int[]{i, 0, v});
                max = Integer.max(max, v);
            }
            int rslt[] = {Q.peek()[2], max};
            while (Q.size() == nums.size()) {
                int[] curr = Q.poll();
                int i = curr[0], j = curr[1], v = curr[2];
                if (max - v < rslt[1] - rslt[0]) {
                    rslt[0] = v;
                    rslt[1] = max;
                }
                if (j + 1 < nums.get(i).size()) {
                    int vv = nums.get(i).get(j + 1);
                    Q.add(new int[]{i, j + 1, vv});
                    max = Math.max(max, vv);
                }
            }
            return rslt;
        }

    }


}
