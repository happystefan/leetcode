package google;

import java.util.*;

public class Q502_IPO {

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> capQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> proQ = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < Capital.length; i++) {
            capQ.add(new int[]{Capital[i], Profits[i]});
        }
        int result = W;
        k = Math.min(k, Capital.length);
        while (k-- > 0) {
            while (!capQ.isEmpty() && capQ.peek()[0] <= result) {
                proQ.add(capQ.poll());
            }
            if (proQ.isEmpty()) {
                break;
            }
            result += proQ.poll()[1];
        }
        return result;
    }

}
