package Y2020.facebook;

public class Q1249_Minimum_Remove_to_Make_Valid_Parentheses {

    public String minRemoveToMakeValid(String s) {
        StringBuffer sb = remove(s, '(', ')');
        return remove(sb.toString(), ')', '(').toString();
    }

    private StringBuffer remove(String s, char lp, char rp) {
        StringBuffer sb = new StringBuffer();
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c != lp && c != rp) sb.append(c);
            else {
                if (c == lp) {
                    sb.append(c);
                    cnt++;
                } else {
                    if (cnt > 0) {
                        sb.append(c);
                        cnt--;
                    }
                }
            }
        }
        sb.reverse();
        return sb;
    }

}
