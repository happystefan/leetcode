package Y2018.facebook;

import java.util.HashSet;
import java.util.Set;

public class Q681_Next_Closest_Time {

    public String nextClosestTime(String time) {
        Set<Character> set = new HashSet<>();
        for (char c : time.toCharArray()) {
            set.add(c);
        }
        String[] ss = time.split(":");
        int h = Integer.valueOf(ss[0]), m = Integer.valueOf(ss[1]);
        do {
            m++;
            if (m == 60) {
                h++;
                m = 0;
            }
            if (h == 24) {
                h = 0;
            }
            time = String.format("%02d:%02d", h, m);
        } while (!isValid(time, set));
        return time;
    }

    private boolean isValid(String str, Set<Character> set) {
        for (char c : str.toCharArray()) {
            if (!set.contains(c)) {
                return false;
            }
        }
        return true;
    }

}
