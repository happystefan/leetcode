package Y2019.Q0001_Q0300;

public class Q0065_Valid_Number {

    public boolean isNumber(String s) {
        if (s == null) return false;
        s = s.trim();
        if (s.length() == 0) return false;
        boolean digitSeen = false;
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
                    if (eSeen || !digitSeen) return false;
                    eSeen = true;
                    digitSeen = false;
                    break;
                case '+':
                case '-':
                    if (i != 0 && s.charAt(i - 1) != 'e') return false;
                    digitSeen = false;
                    break;
                default:
                    if (c < '0' || c > '9') return false;
                    digitSeen = true;
                    break;
            }
        }
        return digitSeen;
    }

}
