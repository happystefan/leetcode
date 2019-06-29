package Y2018.oa.twilio;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Reformating_Dates {

    static List<String> reformatDate(List<String> dates) {
        List<String> result = new LinkedList<>();
        if (dates == null || dates.size() == 0) return result;
        Map<String, String> map = new HashMap<>();
        map.put("Jan", "01");
        map.put("Feb", "02");
        map.put("Mar", "03");
        map.put("Apr", "04");
        map.put("May", "05");
        map.put("Jun", "06");
        map.put("Jul", "07");
        map.put("Aug", "08");
        map.put("Sep", "09");
        map.put("Oct", "10");
        map.put("Nov", "11");
        map.put("Dec", "12");
        for (String date : dates) {
            result.add(reformat(date, map));
        }
        return result;
    }

    static String reformat(String date, Map<String, String> map) {
        String[] ss = date.split(" ");
        int day = Integer.valueOf(ss[0].substring(0, ss[0].length() - 2));
        return String.format("%s-%s-%02d", ss[2], map.get(ss[1]), day);
    }

}
