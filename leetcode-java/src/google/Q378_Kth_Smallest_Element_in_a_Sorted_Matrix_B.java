package google;

import java.util.PriorityQueue;

public class Q378_Kth_Smallest_Element_in_a_Sorted_Matrix_B {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pqueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                pqueue.offer(new int[]{matrix[i][j], i, j});
            }
        }
        while (k != 1) {
            pqueue.poll();
            k--;
        }
        return pqueue.poll()[0];
    }

}
