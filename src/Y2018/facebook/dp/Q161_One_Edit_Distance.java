package Y2018.facebook.dp;

public class Q161_One_Edit_Distance {

    public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        if (Math.abs(m - n) >= 2) return false;
        if (m == n && s.equals(t)) return false;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                return s.substring(i + 1).equals(t.substring(j + 1)) ||
                        s.substring(i + 1).equals(t.substring(j)) ||
                        s.substring(i).equals(t.substring(j + 1));
            }
        }
        return true;
    }

}
