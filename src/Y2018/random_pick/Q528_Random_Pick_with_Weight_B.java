package Y2018.random_pick;

import java.util.Random;
import java.util.TreeMap;

public class Q528_Random_Pick_with_Weight_B {

    class Solution {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Random random = new Random();
        int sum = 0;

        public Solution(int[] w) {
            for (int i = 0; i < w.length; i++) {
                sum += w[i];
                map.put(sum, i);
            }
        }

        public int pickIndex() {
            int target = random.nextInt(sum);
            return map.get(map.higherKey(target));
        }
    }

}
