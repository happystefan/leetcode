package facebook;

public class Q844_Backspace_String_Compare {

    public boolean backspaceCompare(String S, String T) {
        StringBuilder sbs = new StringBuilder();
        StringBuilder sbt = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (c == '#') {
                if (sbs.length() != 0) sbs.deleteCharAt(sbs.length()-1);
            } else {
                sbs.append(c);
            }
        }
        for (char c : T.toCharArray()) {
            if (c == '#') {
                if (sbt.length() != 0) sbt.deleteCharAt(sbt.length()-1);
            } else {
                sbt.append(c);
            }
        }
        return sbs.toString().equals(sbt.toString());
    }

}
