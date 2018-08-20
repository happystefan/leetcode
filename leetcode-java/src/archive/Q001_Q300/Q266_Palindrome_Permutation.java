package archive.Q001_Q300;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mingqiangliang on 12/19/17.
 */
public class Q266_Palindrome_Permutation {

    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (Character c : s.toCharArray()) {
            if (set.contains(c)) set.remove(c);
            else set.add(c);
        }
        return set.size() == 0 || set.size() == 1;
    }

}
