package facebook;

import java.util.*;

public class Q151_Reverse_Words_in_a_String {

    public String reverseWords(String s) {
        List<String> list = new ArrayList<>(Arrays.asList(s.trim().split("\\s+")));
        Collections.reverse(list);
        return String.join(" ", list);
    }

}
