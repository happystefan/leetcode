package Y2020.facebook;

import java.util.HashSet;
import java.util.Set;

public class Q0202_Happy_Number {

    public boolean isHappy(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n)) return false;
            set.add(n);
            int m = 0;
            while (n != 0) {
                m += (n % 10) * (n % 10);
                n /= 10;
            }
            n = m;
        }
        return true;
    }

}
