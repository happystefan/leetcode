package archive.google;

public class Q415_Add_Strings {

    public String addStrings(String num1, String num2) {
        if (num2.length() > num1.length()) {
            String tmp = num2;
            num2 = num1;
            num1 = tmp;
        }
        int len1 = num1.length(), len2 = num2.length();
        char[] s1 = num1.toCharArray(), s2 = num2.toCharArray();
        int c = 0;
        for (int i = 1; i <= len2; i++) {
            int sum = s1[len1-i]-'0'+s2[len2-i]-'0'+c;
            c  = sum/10;
            s1[len1-i] = (char)(sum%10+'0');
        }
        for (int i = len2+1; i <= len1; i++) {
            int sum = s1[len1-i]-'0'+c;
            c  = sum/10;
            s1[len1-i] = (char)(sum%10+'0');
            if (c == 0) break;
        }
        return c > 0 ? (char)(c+'0')+ String.valueOf(s1) : String.valueOf(s1);

    }

}
