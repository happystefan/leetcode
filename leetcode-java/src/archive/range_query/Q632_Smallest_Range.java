package archive.range_query;

import java.util.*;

public class Q632_Smallest_Range {

    public static int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> Q = new PriorityQueue<>((a, b) -> Integer.compare(nums.get(a[0]).get(a[1]), nums.get(b[0]).get(b[1])));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            Q.offer(new int[]{i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }
        int[] result = new int[]{0, Integer.MAX_VALUE};
        while (Q.size() == nums.size()) {
            int[] curr = Q.poll();
            int row = curr[0], col = curr[1];
            if (max-nums.get(row).get(col) < result[1]-result[0]) {
                result[0] = nums.get(row).get(col);
                result[1] = max;
            }
            if (col+1 < nums.get(row).size()) {
                Q.offer(new int[]{row, col+1});
                max = Math.max(max, nums.get(row).get(col + 1));
            }
        }
        return result;
    }

}
