package vmware;

public class Q205_Isomorphic_Strings {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] ss = new int[256];
        int[] tt = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (ss[s.charAt(i)] != tt[t.charAt(i)]) return false;
            ss[s.charAt(i)] = i + 1;
            tt[t.charAt(i)] = i + 1;
        }
        return true;
    }

}
