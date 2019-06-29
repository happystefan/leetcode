package Y2018.google;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q609_Find_Duplicate_File_in_System {

    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] parts = path.split(" ");
            for (int i = 1; i < parts.length; i++) {
                int l = parts[i].indexOf('('), r = parts[i].indexOf(')');
                String content = parts[i].substring(l + 1, r);
                map.computeIfAbsent(content, k -> new LinkedList<>());
                map.get(content).add(parts[0] + "/" + parts[i].substring(0, l).replace(" ", "/"));
            }
        }
        List<List<String>> result = new LinkedList<>();
        for (List<String> v : map.values()) {
            if (v.size() > 1) {
                result.add(v);
            }
        }
        return result;
    }

}
