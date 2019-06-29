package Y2018.facebook;

public class Q248_Strobogrammatic_Number_III {

    private char[][] pairs = new char[][]{{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};

    public int strobogrammaticInRange(String low, String high) {
        if (low == null || high == null || low.length() == 0 || high.length() == 0 ||
                low.length() > high.length() || low.length() == high.length() && low.compareTo(high) > 0) {
            return 0;
        }
        int result = 0;
        for (int i = low.length(); i <= high.length(); i++) {
            result += dfs(low, high, new char[i], 0, i - 1);
        }
        return result;
    }

    private int dfs(String low, String high, char[] ss, int l, int r) {
        if (l > r) {
            if (ss.length == low.length() && low.compareTo(new String(ss)) > 0 ||
                    ss.length == high.length() && high.compareTo(new String(ss)) < 0) {
                return 0;
            } else {
                return 1;
            }
        }
        int result = 0;
        for (char[] pair : pairs) {
            ss[l] = pair[0];
            ss[r] = pair[1];
            if (ss.length != 1 && ss[0] == '0') {
                continue;
            }
            if (l == r && (ss[l] == '6' || ss[l] == '9')) {
                continue;
            }
            result += dfs(low, high, ss, l + 1, r - 1);
        }
        return result;
    }

}
