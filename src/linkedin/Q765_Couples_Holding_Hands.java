package linkedin;

import java.util.HashMap;
import java.util.Map;

public class Q765_Couples_Holding_Hands {

    public int minSwapsCouples(int[] row) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < row.length; i += 2) {
            map.put(row[i], row[i + 1]);
            map.put(row[i + 1], row[i]);
        }
        int result = 0;
        for (int i = 0; i < row.length; i += 2) {
            if (map.get(i) != i + 1) {
                int curr = map.get(i);
                int next = map.get(i + 1);
                map.put(curr, next);
                map.put(next, curr);
                result++;
            }
        }
        return result;
    }

}
