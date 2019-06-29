package Y2018.tree;

import java.util.*;

public class Q582_Kill_Process {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            int p = ppid.get(i);
            int c = pid.get(i);
            map.computeIfAbsent(p, k -> new HashSet<>());
            map.get(p).add(c);
        }
        Queue<Integer> Q = new LinkedList<>();
        Q.add(kill);
        List<Integer> result = new LinkedList<>();
        while (!Q.isEmpty()) {
            int p = Q.poll();
            result.add(p);
            if (map.get(p) != null) {
                Q.addAll(map.get(p));
                map.remove(p);
            }
        }
        return result;
    }

}
