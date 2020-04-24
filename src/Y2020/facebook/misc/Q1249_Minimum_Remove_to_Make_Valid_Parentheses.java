package Y2020.facebook.misc;

public class Q1249_Minimum_Remove_to_Make_Valid_Parentheses {

    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        remove(sb, s.toCharArray(), '(', ')');
        String rs = sb.reverse().toString();
        sb.setLength(0);
        remove(sb, rs.toCharArray(), ')', '(');
        return sb.reverse().toString();
    }

    private void remove(StringBuilder sb, char[] ss, char l, char r) {
        int cnt = 0;
        for (char c : ss) {
            if (c != l && c != r) {
                sb.append(c);
            } else if (c == l) {
                cnt++;
                sb.append(c);
            } else {
                if (cnt > 0) {
                    cnt--;
                    sb.append(c);
                }
            }
        }
    }

}
