package Y2018.google;

public class Q394_Decode_String {

    public String decodeString(String s) {
        if (s.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int numStart = i;
                while (s.charAt(i) != '[') i++;
                int num = Integer.valueOf(s.substring(numStart, i));
                int cnt = 1;
                i++;
                int strStart = i;
                while (cnt != 0) {
                    if (s.charAt(i) == '[') cnt++;
                    if (s.charAt(i) == ']') cnt--;
                    i++;
                }
                i--;
                String str = decodeString(s.substring(strStart, i));
                while (num-- > 0) {
                    sb.append(str);
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

}
