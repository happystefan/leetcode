package google;



/**
 * Created by mingqiangliang on 12/23/17.
 */
public class Q655_Big_Integer_Addition {

    public String addStrings(String num1, String num2) {
        // write your code here
        char[] c1 = num1.length() > num2.length() ? num1.toCharArray() : num2.toCharArray();
        char[] c2 = num1.length() > num2.length() ? num2.toCharArray() : num1.toCharArray();
        int carry = 0;
        int l1 = c1.length-1, l2 = c2.length-1;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < c2.length; i++) {
            int sum = c1[l1 - i] - '0' + c2[l2 - i] - '0' + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        for (int i = c2.length; i < c1.length; i++) {
            int sum = c1[l1 - i] - '0' + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        if (carry == 1) sb.append(carry);
        return sb.reverse().toString();
    }

}
