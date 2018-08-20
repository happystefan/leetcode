package archive.Q001_Q300;

import java.util.Arrays;

public class Q242_Valid_Anagram {

    public boolean isAnagram(String s, String t) {
        char[] ss = s.toCharArray(), tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        return Arrays.toString(ss).equals(Arrays.toString(tt));
    }

}
