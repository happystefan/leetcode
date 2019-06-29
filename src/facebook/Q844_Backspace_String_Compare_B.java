package facebook;

public class Q844_Backspace_String_Compare_B {

    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        while (i >= 0 || j >= 0) {
            int skipi = 0;
            int skipj = 0;
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipi++;
                } else if (skipi > 0) {
                    skipi--;
                } else {
                    break;
                }
                i--;
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipj++;
                } else if (skipj > 0) {
                    skipj--;
                } else {
                    break;
                }
                j--;
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
                i--;
                j--;
            } else {
                return i == -1 && j == -1;
            }
        }
        return true;
    }

}
