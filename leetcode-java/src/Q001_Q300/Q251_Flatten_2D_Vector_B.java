package Q001_Q300;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Q251_Flatten_2D_Vector_B {

    public class Vector2D implements Iterator<Integer> {

        List<Iterator> list = new LinkedList<>();
        int idx;
        Iterator cur;

        public Vector2D(List<List<Integer>> vec2d) {
            for (List<Integer> vec : vec2d) list.add(vec.iterator());
            idx = 0;
            if (vec2d.size() > 0) cur = list.get(0);
        }

        @Override
        public Integer next() {
            while (!cur.hasNext()) {
                idx++;
                cur = list.get(idx);
            }
            return (Integer)cur.next();
        }

        @Override
        public boolean hasNext() {
            if (cur == null) return false;
            while (!cur.hasNext()) {
                idx++;
                if (idx == list.size()) return false;
                cur = list.get(idx);
            }
            return cur.hasNext();
        }
    }

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */

}
