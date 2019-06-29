package graph;

import java.util.HashMap;
import java.util.Map;

public class Q399_Evaluate_Division {

    Map<String, Integer> map = new HashMap<>();

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        for (String[] pair : equations) {
            if (!map.containsKey(pair[0])) {
                map.put(pair[0], map.size());
            }
            if (!map.containsKey(pair[1])) {
                map.put(pair[1], map.size());
            }
        }
        int n = map.size();
        double[][] graph = new double[n][n];
        boolean[][] valid = new boolean[n][n];
        for (int i = 0; i < equations.length; i++) {
            int a = map.get(equations[i][0]), b = map.get(equations[i][1]);
            graph[a][b] = values[i];
            graph[b][a] = 1 / values[i];
            graph[a][a] = 1;
            graph[b][b] = 1;
            valid[a][b] = true;
            valid[b][a] = true;
            valid[a][a] = true;
            valid[b][b] = true;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (valid[i][k] && valid[k][j]) {
                        graph[i][j] = graph[i][k] * graph[k][j];
                        valid[i][j] = true;
                    }
                }
            }
        }

        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String a = queries[i][0], b = queries[i][1];
            if (!map.containsKey(a) || !map.containsKey(b)) {
                result[i] = -1.0;
                continue;
            }
            int ai = map.get(a), bi = map.get(b);
            result[i] = valid[ai][bi] ? graph[ai][bi] : -1.0;
        }
        return result;
    }

}
