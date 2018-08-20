package archive.facebook;

import java.util.*;

public class Q281_Zigzag_Iterator {

    public class ZigzagIterator {

        Iterator<Integer> it1;
        Iterator<Integer> it2;
        int cnt = 0;
        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            it1 = v1.iterator();
            it2 = v2.iterator();
        }

        public int next() {
            if (!it1.hasNext()) return it2.next();
            if (!it2.hasNext()) return it1.next();
            int result = cnt%2 == 0 ? it1.next() : it2.next();
            cnt++;
            return result;
        }

        public boolean hasNext() {
            if (!it1.hasNext()) return it2.hasNext();
            if (!it2.hasNext()) return it1.hasNext();
            return cnt%2 == 0 ? it1.hasNext() : it2.hasNext();
        }
    }

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */

}
