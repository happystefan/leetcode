package facebook;

public class Q640_Edit_Distance_II {

    public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        if (m > n) {
            return isOneEditDistance(t, s);
        }
        if (n-m > 1) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) == t.charAt(i)) {
                continue;
            }
            if (m != n) {
                return s.substring(i).equals(t.substring(i+1));
            } else  {
                return s.substring(i+1).equals(t.substring(i+1));
            }
        }
        return m != n;
    }

}
