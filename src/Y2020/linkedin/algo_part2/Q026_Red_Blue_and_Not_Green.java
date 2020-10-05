package Y2020.linkedin.algo_part2;

import java.util.*;

public class Q026_Red_Blue_and_Not_Green {

    // Assume list red, blue and green are all sorted
    List<Integer> redBlueAndNotGreen(List<Integer> red, List<Integer> blue, List<Integer> green) {
        Iterator<Integer> itr = red.iterator();
        Iterator<Integer> itb = blue.iterator();
        Iterator<Integer> itg = blue.iterator();

        Integer r = itr.hasNext() ? itr.next() : null;
        Integer b = itb.hasNext() ? itb.next() : null;
        Integer g = itg.hasNext() ? itg.next() : null;

        List<Integer> rslt = new LinkedList<>();
        while (r != null && b != null) {
            if (r < b) {
                r = itr.hasNext() ? itr.next() : null;
            } else if (b < r) {
                b = itb.hasNext() ? itb.next() : null;
            } else {
                while (g != null && g < r) {
                    g = itg.hasNext() ? itg.next() : null;
                }
                if (g != null && g.intValue() != r.intValue()) {
                    rslt.add(r);
                }
                r = itr.hasNext() ? itr.next() : null;
                b = itb.hasNext() ? itb.next() : null;
            }
        }
        return rslt;
    }
}
