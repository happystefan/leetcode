package archive.range_query;

import java.util.*;

public class Q218_The_Skyline_Problem {

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new LinkedList<>();
        List<int[]> height = new LinkedList<>();
        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, (a, b)-> a[0] != b[0] ? a[0]-b[0] : a[1]-b[1]);
        PriorityQueue<Integer> Q = new PriorityQueue<>((a, b) -> b-a);
        Q.offer(0);
        int prev = 0;
        for (int[] h: height) {
            if (h[1] < 0) {
                Q.offer(-h[1]);
            } else {
                Q.remove(h[1]);
            }
            int curr = Q.peek();
            if (curr != prev) {
                result.add(new int[]{h[0], curr});
                prev = curr;
            }
        }
        return result;
    }

}
