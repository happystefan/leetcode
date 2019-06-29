package Y2018.Q001_Q300;

import java.util.HashSet;
import java.util.Set;

public class Q202_Happy_Number {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            set.add(n);
            int nn = 0;
            while (n != 0) {
                nn += (n % 10) * (n % 10);
                n /= 10;
            }
            if (set.contains(nn)) return false;
            n = nn;
        }
        return true;
    }

}
