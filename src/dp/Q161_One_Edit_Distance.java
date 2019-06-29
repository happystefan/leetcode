package dp;

public class Q161_One_Edit_Distance {

    public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        if (Math.abs(m - n) >= 2) {
            return false;
        }
        if (s.equals(t)) {
            return false;
        }
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) != t.charAt(j)) {
                return s.substring(i + 1, m).equals(t.substring(j + 1, n)) ||
                        s.substring(i + 1, m).equals(t.substring(j, n)) ||
                        s.substring(i, m).equals(t.substring(j + 1, n));
            }
            i++;
            j++;
        }
        return true;
    }

}
