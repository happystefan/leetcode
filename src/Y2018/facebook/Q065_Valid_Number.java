package Y2018.facebook;

public class Q065_Valid_Number {

    public boolean isNumber(String s) {
        /*
        "0" => true
        " 0.1 " => true
        "abc" => false
        "1 a" => false
        "2e10" => true
        */
        if (s == null || s.trim().length() == 0) {
            return false;
        }
        s = s.trim();
        boolean numSeen = false;
        boolean pointSeen = false;
        boolean eSeen = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '.':
                    if (pointSeen || eSeen) return false;
                    pointSeen = true;
                    break;
                case 'e':
                    if (eSeen || !numSeen) return false;
                    eSeen = true;
                    numSeen = false;
                    break;
                case '+':
                case '-':
                    if (i != 0 && s.charAt(i - 1) != 'e') return false;
                    numSeen = false;
                    break;
                default:
                    if (c - '0' < 0 || c - '0' > 9) return false;
                    numSeen = true;
            }
        }
        return numSeen;
    }

}