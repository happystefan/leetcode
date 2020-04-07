package Y2020.facebook;

public class Q0242_Valid_Anagram {

    public boolean isAnagram(String s, String t) {
        int[] p = new int[26];
        for (char c : s.toCharArray()) p[c - 'a']++;
        for (char c : t.toCharArray()) p[c - 'a']--;
        for (int i = 0; i < p.length; i++) if (p[i] != 0) return false;
        return true;
    }

}
