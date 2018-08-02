package sort;

import java.util.*;

public class Q179_Largest_Number {

    public String largestNumber(int[] nums) {
        List<String> list  = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        Collections.sort(list, (a, b)->((b+a).compareTo(a+b)));
        if (list.size() > 1 && list.get(0).equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }
        return sb.toString();
    }

}
