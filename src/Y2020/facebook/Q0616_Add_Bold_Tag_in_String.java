package Y2020.facebook;

public class Q0616_Add_Bold_Tag_in_String {

    public String addBoldTag(String s, String[] dict) {
        int[] bold = new int[s.length() + 1];
        for (String word : dict) {
            int i = -1;
            while ((i = s.indexOf(word, i + 1)) >= 0) {
                bold[i]++;
                bold[i + word.length()]--;
            }
        }
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = 0; i <= s.length(); i++) {
            int cur = sum + bold[i];
            if (sum > 0 && cur == 0) sb.append("</b>");
            if (cur > 0 && sum == 0) sb.append("<b>");
            if (i == s.length()) break;
            sb.append(s.charAt(i));
            sum = cur;
        }
        return sb.toString();
    }

}
