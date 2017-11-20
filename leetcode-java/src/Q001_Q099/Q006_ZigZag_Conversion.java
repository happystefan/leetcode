package Q001_Q099;

/**
 * Created by mqliang on 5/27/17.
 */
public class Q006_ZigZag_Conversion {
    public String convert(String s, int numRows) {
        StringBuffer []sb = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuffer(s.length());
        }

        for (int i = 0; i < s.length(); ) {
            for (int j = 0; j < numRows && i < s.length(); j++) {
                sb[j].append(s.charAt(i++));
            }
            for (int j = numRows-2; j >= 1 && i < s.length(); j--) {
                sb[j].append(s.charAt(i++));
            }
        }

        for (int i = 1; i < numRows; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}
