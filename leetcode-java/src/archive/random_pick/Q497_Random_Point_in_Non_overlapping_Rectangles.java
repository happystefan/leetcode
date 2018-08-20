package archive.random_pick;

import java.util.*;

public class Q497_Random_Point_in_Non_overlapping_Rectangles {

    class Solution {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[][] rects;
        int area = 0;
        Random random = new Random();
        public Solution(int[][] rects) {
            for (int i = 0; i < rects.length; i++) {
                int[] rect = rects[i];
                area += (rect[2]-rect[0]+1)*(rect[3]-rect[1]+1);
                map.put(area, i);
            }
            this.rects = rects;
        }

        public int[] pick() {
            int randomArea = random.nextInt(area);
            int higherArea = map.higherKey(randomArea);
            int[] rect = rects[map.get(higherArea)];
            int[] result = new int[2];
            result[0] = rect[0] + (higherArea - randomArea - 1) % (rect[2] - rect[0] + 1);
            result[1] = rect[1] + (higherArea - randomArea - 1) / (rect[2] - rect[0] + 1);
            return result;
        }

    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */

}
