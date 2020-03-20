package Y2020.facebook;

public class Q0415_Add_Strings {

    public String addStrings(String num1, String num2) {
        StringBuffer sb = new StringBuffer();
        int i = num1.length() - 1, j = num2.length() - 1;
        int c = 0;
        while (i >= 0 || j >= 0 || c != 0) {
            if (i >= 0) c += num1.charAt(i--) - '0';
            if (j >= 0) c += num2.charAt(j--) - '0';
            sb.insert(0, c % 10);
            c /= 10;
        }
        return sb.toString();
    }

}
