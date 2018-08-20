package archive.google;

import java.util.*;

public class Q635_Design_Log_Storage_System {

    class LogSystem {
        TreeMap<String, List<Integer>> map = new TreeMap<>();
        String min = "2000:01:01:00:00:00";
        String max = "2017:12:31:23:59:59";
        Map<String, Integer> index = new HashMap<>();
        public LogSystem() {
            index.put("Year", 4);
            index.put("Month", 7);
            index.put("Day", 10);
            index.put("Hour", 13);
            index.put("Minute", 16);
            index.put("Second", 19);
        }
        public void put(int id, String timestamp) {
            map.computeIfAbsent(timestamp, k -> new LinkedList<>());
            map.get(timestamp).add(id);
        }
        public List<Integer> retrieve(String s, String e, String gra) {
            int idx = index.get(gra);
            s = s.substring(0, idx)+min.substring(idx);
            e = e.substring(0, idx)+max.substring(idx);
            Map<String, List<Integer>> sub = map.subMap(s, true, e, true);
            List<Integer> result = new LinkedList<>();
            for (List<Integer> ids : sub.values()) {
                result.addAll(ids);
            }
            return result;
        }
    }

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */

}
