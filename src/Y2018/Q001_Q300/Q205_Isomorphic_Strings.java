package Y2018.Q001_Q300;

public class Q205_Isomorphic_Strings {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != s.length()) return false;
        int[] ms = new int[256];
        int[] mt = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (ms[s.charAt(i)] != mt[t.charAt(i)]) return false;
            ms[s.charAt(i)] = mt[t.charAt(i)] = i + 1;
        }
        return true;
    }

}
