package Q100_Q199;

import java.util.List;

public class Q120_Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size()-2; i >= 0; i++) {
            List<Integer> row = triangle.get(i);
            List<Integer> nxt = triangle.get(i+1);
            for (int j =0; j < row.size(); j++ ) {
                row.set(j,row.get(j)+Math.min(nxt.get(j), nxt.get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }

}
