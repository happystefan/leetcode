package facebook;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q763_Partition_Labels {

    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> map = new HashMap<>();
        char[] ss = S.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            map.put(ss[i], i);
        }
        List<Integer> result = new LinkedList<>();
        int start = 0, end = 0;
        for (int i = 0; i < ss.length; i++) {
            end = Math.max(end, map.get(ss[i]));
            if (end == i) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }

}
