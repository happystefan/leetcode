package Y2018.oa.coursera;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Magical_Binary_String {

    public static String largestMagical(String binString) {
        // Write your code here
        int count = 0, i = 0;
        List<String> res = new ArrayList<>();
        for (int j = 0; j < binString.length(); ++j) {
            if (binString.charAt(j) == '1') count++;
            else count--;
            if (count == 0) {
                res.add('1' + largestMagical(binString.substring(i + 1, j)) + '0');
                i = j + 1;
            }
        }
        Collections.sort(res, Collections.reverseOrder());
        return String.join("", res);
    }

}
