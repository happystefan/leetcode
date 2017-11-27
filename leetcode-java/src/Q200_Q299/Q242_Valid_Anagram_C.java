package Q200_Q299;

public class Q242_Valid_Anagram_C {

    public boolean isAnagram(String s, String t) {
        int[] f = new int[26];
        for (char c : s.toCharArray()) f[c-'a']++;
        for (char c : t.toCharArray()) f[c-'a']--;
        for (int n : f) if (n != 0) return false;
        return true;
    }

}
