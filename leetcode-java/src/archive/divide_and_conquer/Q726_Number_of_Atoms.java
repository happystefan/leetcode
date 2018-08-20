package archive.divide_and_conquer;

import java.util.*;

public class Q726_Number_of_Atoms {

    int i;
    public String countOfAtoms(String formula) {
        StringBuilder result = new StringBuilder();
        i = 0;
        Map<String, Integer> map = parse(formula);
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for (String key: keys) {
            result.append(key);
            int cnt = map.get(key);
            if (cnt > 1) result.append(cnt);
        }
        return new String(result);
    }

    public Map<String, Integer> parse(String formula) {
        int N = formula.length();
        Map<String, Integer> map = new HashMap<>();
        while (i < N && formula.charAt(i) != ')') {
            if (formula.charAt(i) == '(') {
                i++;
                for (Map.Entry<String, Integer> entry: parse(formula).entrySet()) {
                    map.put(entry.getKey(), map.getOrDefault(entry.getKey(), 0) + entry.getValue());
                }
            } else {
                int iStart = i++;
                while (i < N && Character.isLowerCase(formula.charAt(i))) i++;
                String name = formula.substring(iStart, i);
                iStart = i;
                while (i < N && Character.isDigit(formula.charAt(i))) i++;
                int cnt = iStart < i ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                map.put(name, map.getOrDefault(name, 0) + cnt);
            }
        }
        int iStart = ++i;
        while (i < N && Character.isDigit(formula.charAt(i))) i++;
        if (iStart < i) {
            int cnt = Integer.parseInt(formula.substring(iStart, i));
            for (String key: map.keySet()) {
                map.put(key, map.get(key) * cnt);
            }
        }
        return map;
    }

}
