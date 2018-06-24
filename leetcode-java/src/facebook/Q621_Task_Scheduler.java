package facebook;

import java.util.*;

public class Q621_Task_Scheduler {

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        int max = 0;
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0)+1);
            if (map.get(c) >= max) {
                if (map.get(c) > max) {
                    set.clear();
                }
                max = map.get(c);
                set.add(c);
            }
        }
        return Math.max(tasks.length, (max-1)*(n+1)+set.size());
    }

}
