package Y2020.facebook.misc;

public class Q0043_Multiply_Strings {

    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) return null;
        int m = num1.length(), n = num2.length();
        int[] rslt = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = rslt[i + j + 1] + mul;
                rslt[i + j + 1] = sum % 10;
                rslt[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : rslt) {
            if (i == 0 && sb.length() == 0) continue;
            sb.append(i);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

}
