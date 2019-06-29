package Y2018.facebook;

import java.util.Iterator;
import java.util.List;

public class Q251_Flatten_2D_Vector {

    public class Vector2D implements Iterator<Integer> {

        Iterator<List<Integer>> rowIt;
        Iterator<Integer> colIt;

        public Vector2D(List<List<Integer>> vec2d) {
            rowIt = vec2d.iterator();
            if (rowIt.hasNext()) {
                colIt = rowIt.next().iterator();
            }
        }

        @Override
        public Integer next() {
            return colIt.next();
        }

        @Override
        public boolean hasNext() {
            while ((colIt == null || !colIt.hasNext()) && rowIt.hasNext()) {
                colIt = rowIt.next().iterator();
            }
            return colIt != null && colIt.hasNext();
        }
    }

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */

}
