package facebook;

public class Q408_Add_Binary {

    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String c = a;
            a = b;
            b = c;
        }
        char[] aa = new StringBuilder(a).reverse().toString().toCharArray();
        char[] bb = new StringBuilder(b).reverse().toString().toCharArray();

        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < b.length(); i++) {
            int sum = aa[i]-'0' + bb[i]-'0' + carry;
            result.append(sum % 2);
            carry = sum/2;
        }
        for (int i = b.length(); i < a.length(); i++) {
            int sum = aa[i]-'0' + carry;
            result.append(sum % 2);
            carry = sum/2;
        }
        if (carry != 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }

}
