package archive.google;

import java.util.HashMap;
import java.util.Map;

public class Q399_Evaluate_Division {

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            Double value = values[i];
            String s = equation[0], e = equation[1];
            map.computeIfAbsent(s, a -> new HashMap<>()).put(s, 1d);
            map.computeIfAbsent(e, a -> new HashMap<>()).put(e, 1d);
            map.get(s).put(e, value);
            map.get(e).put(s, 1.0/value);
        }
        for ( String k : map.keySet()) {
            for (String i : map.get(k).keySet()) {
                for (String j : map.get(k).keySet()) {
                    map.get(i).put(j, map.get(i).get(k)*map.get(k).get(j));
                }
            }
        }

        double[] ans = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String s = queries[i][0], e = queries[i][1];
            if (map.containsKey(s) && map.get(s).containsKey(e)) ans[i] = map.get(s).get(e);
            else ans[i] = -1.0;
        }
        return ans;
    }

}
