package Y2018.facebook;

public class Q844_Backspace_String_Compare_C {

    public boolean backspaceCompare(String S, String T) {
        for (int i = S.length() - 1, j = T.length() - 1; ; i--, j--) {
            for (int b = 0; i >= 0 && (b > 0 || S.charAt(i) == '#'); i--) b += S.charAt(i) == '#' ? 1 : -1;
            for (int b = 0; j >= 0 && (b > 0 || T.charAt(j) == '#'); j--) b += T.charAt(j) == '#' ? 1 : -1;
            if (i < 0 || j < 0 || S.charAt(i) != T.charAt(j)) return i == -1 && j == -1;
        }

    }

}
