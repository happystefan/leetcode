package google;

import java.util.*;

public class Q519_Random_Flip_Matrix {

    class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        Random random = new Random();
        int rows = 0;
        int cols = 0;
        int total = 0;
        public Solution(int n_rows, int n_cols) {
            rows = n_rows;
            cols = n_cols;
            total = n_rows*n_cols;
        }

        public int[] flip() {
            int idx = random.nextInt(total--);
            int val = map.getOrDefault(idx, idx);
            map.put(idx, map.getOrDefault(total, total));
            return new int[]{val/cols, val%cols};
        }

        public void reset() {
            total = rows*cols;
            map.clear();
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n_rows, n_cols);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */

}
