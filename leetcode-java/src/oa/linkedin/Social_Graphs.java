package oa.linkedin;

import java.util.*;
import java.util.stream.Collectors;

public class Social_Graphs {

    public static void socialGraphs(List<Integer> counts) {
        // Write your code here
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < counts.size(); i++) {
            int cnt = counts.get(i);
            map.computeIfAbsent(cnt, k -> new ArrayList<>());
            map.get(cnt).add(i);
        }
        List<List<Integer>> result = new LinkedList<>();
        for (int cnt : map.keySet()) {
            List<Integer> list = map.get(cnt);
            for (int i = 0; i < list.size(); i++) {
                if (i % cnt == 0) result.add(new LinkedList<>());
                result.get(result.size()-1).add(list.get(i));
            }
        }

        Collections.sort(result, (a, b) -> (a.get(0)-b.get(0)));
        for (List<Integer> list : result) {
            System.out.println(String.join(" ", list.stream().map(Object::toString).collect(Collectors.toList())));
        }
    }

}
