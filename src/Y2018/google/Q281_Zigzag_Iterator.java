package Y2018.google;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q281_Zigzag_Iterator {

    public class ZigzagIterator {

        Queue<Iterator> queue = new LinkedList<>();

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            if (v1.iterator().hasNext()) queue.add(v1.iterator());
            if (v2.iterator().hasNext()) queue.add(v2.iterator());
        }

        public int next() {
            Iterator iterator = queue.poll();
            int next = (int) iterator.next();
            if (iterator.hasNext()) queue.add(iterator);
            return next;
        }

        public boolean hasNext() {
            return queue.size() != 0;
        }

    }

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */

}
