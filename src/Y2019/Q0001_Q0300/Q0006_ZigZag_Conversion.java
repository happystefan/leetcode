package Y2019.Q0001_Q0300;

public class Q0006_ZigZag_Conversion {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: simulation
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public String convert_simulation(String s, int numRows) {
        StringBuilder sb[] = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) sb[i] = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            for (int j = 0; j < numRows && i < s.length(); j++) {
                sb[j].append(s.charAt(i++));
            }
            for (int j = numRows - 2; j >= 1 && i < s.length(); j--) {
                sb[j].append(s.charAt(i++));
            }
        }
        for (int j = 1; j < numRows; j++) sb[0].append(sb[j]);
        return sb[0].toString();
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: calculate destination index
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || s.length() == 1 || numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        int step = 2 * (numRows - 1);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < s.length(); j += step) {
                sb.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + step - i < s.length()) {
                    sb.append(s.charAt(j + step - i));
                }
            }
        }
        return sb.toString();
    }

}
