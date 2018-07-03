package Q001_Q300;

public class Q242_Valid_Anagram_B {

    public boolean isAnagram(String s, String t) {
        int[] ss = new int[26];
        int[] tt = new int[26];
        for (char c : s.toCharArray()) ss[c-'a']++;
        for (char c : t.toCharArray()) tt[c-'a']++;
        for (int i = 0; i < 26; i++) if (ss[i] != tt[i]) return false;
        return true;
    }

}
