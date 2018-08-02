package sort;

import java.util.*;

public class Q242_Valid_Anagram {

    public boolean isAnagram(String s, String t) {
        char[] ss = s.toCharArray(), tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        return new String(ss).equals(new String(tt));
    }

}
