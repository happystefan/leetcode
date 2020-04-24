package Y2020.facebook;

public class Q1309_Decrypt_String_from_Alphabet_to_Integer_Mapping {

    public String freqAlphabets(String s) {
        if (s == null || s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (i + 2 < ss.length && ss[i + 2] == '#') {
                int v = Integer.valueOf(s.substring(i, i + 2));
                sb.append((char) ('a' + v - 1));
                i += 2;
            } else {
                int v = Integer.valueOf(s.substring(i, i + 1));
                sb.append((char) ('a' + v - 1));
            }
        }
        return sb.toString();
    }

}
