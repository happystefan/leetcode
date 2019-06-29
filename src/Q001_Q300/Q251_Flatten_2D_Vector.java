package Q001_Q300;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Q251_Flatten_2D_Vector {

    public class Vector2D implements Iterator<Integer> {

        List<Integer> list = new LinkedList<>();
        Iterator lit;

        public Vector2D(List<List<Integer>> vec2d) {
            Iterator it = vec2d.listIterator();
            while (it.hasNext()) {
                List<Integer> ll = (List<Integer>) it.next();
                list.addAll(ll);
            }
            lit = list.listIterator();
        }

        @Override
        public Integer next() {
            return (Integer) lit.next();
        }

        @Override
        public boolean hasNext() {
            return lit.hasNext();
        }
    }

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */

}
