package archive.facebook;

public class Q415_Add_Strings {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length()-1, j = num2.length()-1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) sum += num1.charAt(i--)-'0';
            if (j >= 0) sum += num2.charAt(j--)-'0';
            sb.insert(0, sum%10);
            carry = sum/10;
        }
        return sb.toString();
    }

}
