package archive.google;

import java.util.*;

public class Q179_Largest_Number {

    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        Collections.sort(list, (a, b) -> (b+a).compareTo(a+b));
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }
        return sb.toString();
    }

}
