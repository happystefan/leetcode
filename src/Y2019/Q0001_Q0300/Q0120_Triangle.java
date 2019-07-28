package Y2019.Q0001_Q0300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q0120_Triangle {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: top down
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution1 {

        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle == null || triangle.size() == 0) return 0;
            List<Integer> sum = new ArrayList(Arrays.asList(triangle.get(0).get(0)));
            for (int i = 1; i < triangle.size(); i++) {
                List<Integer> list = new ArrayList<>(triangle.get(i));
                list.set(0, list.get(0) + sum.get(0));
                list.set(list.size() - 1, list.get(list.size() - 1) + sum.get(sum.size() - 1));
                for (int j = 1; j < list.size() - 1; j++) {
                    list.set(j, Math.min(sum.get(j - 1), sum.get(j)) + list.get(j));
                }
                sum = list;
            }
            return Collections.min(sum);
        }

    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: bottom up
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution2 {

        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle == null || triangle.size() == 0) return 0;
            List<Integer> sum = new ArrayList<>(triangle.get(triangle.size() - 1));
            for (int i = triangle.size() - 2; i >= 0; i--) {
                List<Integer> list = new ArrayList<>(triangle.get(i));
                for (int j = 0; j < list.size(); j++) list.set(j, list.get(j) + Math.min(sum.get(j), sum.get(j + 1)));
                sum = list;
            }
            return sum.get(0);
        }
    }

}
