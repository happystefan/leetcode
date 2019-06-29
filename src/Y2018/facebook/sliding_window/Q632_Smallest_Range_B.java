package Y2018.facebook.sliding_window;

import java.util.List;
import java.util.PriorityQueue;

public class Q632_Smallest_Range_B {

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Pair> Q = new PriorityQueue<>((a, b) -> nums.get(a.row).get(a.col) - nums.get(b.row).get(b.col));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            Q.offer(new Pair(i, 0));
            max = Math.max(max, nums.get(i).get(0));
        }
        int[] result = new int[]{0, Integer.MAX_VALUE};
        while (Q.size() == nums.size()) {
            Pair curr = Q.poll();
            if (max - nums.get(curr.row).get(curr.col) < result[1] - result[0]) {
                result = new int[]{nums.get(curr.row).get(curr.col), max};
            }
            if (curr.col + 1 < nums.get(curr.row).size()) {
                Q.offer(new Pair(curr.row, curr.col + 1));
                max = Math.max(max, nums.get(curr.row).get(curr.col + 1));
            }
        }
        return result;
    }

    class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
