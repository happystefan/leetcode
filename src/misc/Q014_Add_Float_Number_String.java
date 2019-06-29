package misc;

public class Q014_Add_Float_Number_String {

    // one of archive.facebook phone interview problem
    public String addFloatNumberString(String a, String b) {
        if (a == null && b == null) return "0";
        if (a == null) return b;
        if (b == null) return a;

        if (!a.contains(".")) a += ".0";
        if (!b.contains(".")) b += ".0";
        String[] ab = new String[]{a, b};
        addPrefix(ab);
        addSuffix(ab);
        a = ab[0];
        b = ab[1];

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(i) == '.') {
                sb.insert(0, ".");
                continue;
            }
            int sum = a.charAt(i) - '0' + b.charAt(i) - '0' + carry;
            sb.insert(0, sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }

    private void addPrefix(String[] ab) {
        String a = ab[0], b = ab[1];
        int dota = a.indexOf("."), dotb = b.indexOf(".");
        if (dota == dotb) {
            return;
        }
        if (dota > dotb) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        StringBuilder prefix = new StringBuilder();
        for (int i = dota; i < dotb; i++) {
            prefix.append("0");
        }
        a = prefix.toString() + a;

        ab[0] = a;
        ab[1] = b;
    }

    private void addSuffix(String[] ab) {
        String a = ab[0], b = ab[1];
        if (a.length() == b.length()) {
            return;
        }
        if (a.length() > b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        StringBuilder suffix = new StringBuilder();
        for (int i = a.length(); i < b.length(); i++) {
            suffix.append("0");
        }
        a += suffix.toString();
        ab[0] = a;
        ab[1] = b;
    }

}
