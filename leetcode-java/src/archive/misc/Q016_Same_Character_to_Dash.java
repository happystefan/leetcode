package archive.misc;

public class Q016_Same_Character_to_Dash {

    public String sameCharacterToDash(String str) {
        if (str.length() <= 2) {
            return str;
        }
        char[] ss = str.toCharArray();
        for (int i = 1; i < ss.length; i++) {
            if (ss[i] == '-') {
                ss[i] = ss[i-1];
            }
        }

        int i = 1;
        for (i = 1; i < ss.length; i++) {
            if (ss[i] == ss[i-1]) {
                while (i < ss.length && ss[i] == ss[i - 1]) {
                    ss[i - 1] = '+';
                    i++;
                }
                ss[i-1] = '+';
            }
        }
        return new String(ss);
    }

}
