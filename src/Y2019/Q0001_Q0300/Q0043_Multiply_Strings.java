package Y2019.Q0001_Q0300;

public class Q0043_Multiply_Strings {

    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] mul = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int sum = mul[i + j + 1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                mul[i + j] += sum / 10;
                mul[i + j + 1] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : mul) {
            if (sb.length() == 0 && i == 0) continue;
            sb.append(i);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

}
