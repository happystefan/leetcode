package Y2020.facebook.misc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q0599_Minimum_Index_Sum_of_Two_Lists {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list2.length; i++) map.put(list2[i], i);
        List<String> rslt = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            if (!map.containsKey(list1[i])) continue;
            int dist = i + map.get(list1[i]);
            if (dist < min) {
                min = dist;
                rslt.clear();
            }
            if (dist == min) rslt.add(list1[i]);
        }
        return rslt.toArray(new String[rslt.size()]);
    }

}
