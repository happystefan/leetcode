package Y2019.facebook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q0621_Task_Scheduler {

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        int max = 0;
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
            int cnt = map.get(task);
            if (cnt > max) {
                set.clear();
                max = cnt;
            }
            if (cnt == max) set.add(task);
        }
        return Math.max(tasks.length, (n + 1) * (max - 1) + set.size());
    }

    // tasks must be done with original order
    static class followup {

        public int leastInterval(char[] tasks, int cooldown) {
            HashMap<Character, Integer> map = new HashMap<>();
            int time = 0;
            for (char task : tasks) {
                if (!map.containsKey(task)) {
                    time++;
                    map.put(task, time);
                } else {
                    time++;
                    while (time < map.get(task) + cooldown + 1) time++;
                    map.put(task, time);
                }
            }
            return time;
        }

    }

}
