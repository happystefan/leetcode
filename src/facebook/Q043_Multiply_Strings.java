package facebook;

public class Q043_Multiply_Strings {

    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] result = new int[m + n];
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + result[i + j + 1];
                result[i + j] = sum % 10;
                result[i + j + 1] = sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : result) if (!(sb.length() == 0 && i == 0)) sb.append(i);
        return sb.length() == 0 ? "0" : sb.toString();
    }

}
