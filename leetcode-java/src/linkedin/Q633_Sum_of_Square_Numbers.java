package linkedin;

import java.util.HashSet;
import java.util.Set;

public class Q633_Sum_of_Square_Numbers {

    public boolean judgeSquareSum(int c) {
        Set<Long> set = new HashSet<>();
        for (long i = 0; i * i <= c; i++) {
            set.add(i * i);
            if (set.contains(c - i * i)) {
                return true;
            }
        }
        return false;
    }

}
