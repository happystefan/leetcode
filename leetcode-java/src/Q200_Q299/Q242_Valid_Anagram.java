package Q200_Q299;

/**
 * Created by mingqiangliang on 12/18/17.
 */
public class Q242_Valid_Anagram {

    public boolean isAnagram(String s, String t) {
        int[] ss = new int[26], tt = new int[26];
        for (char c : s.toCharArray()) ss[c-'a']++;
        for (char c : t.toCharArray()) tt[c-'a']++;
        for (int i = 0; i < 26; i++) {
            if (ss[i] != tt[i]) return false;
        }
        return true;
    }

}
