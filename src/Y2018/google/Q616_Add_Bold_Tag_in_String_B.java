package Y2018.google;

public class Q616_Add_Bold_Tag_in_String_B {

    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for (String word : dict) {
            int idx = s.indexOf(word);
            while (idx != -1) {
                for (int i = idx; i < idx + word.length(); i++) {
                    bold[i] = true;
                }
                idx = s.indexOf(word, idx + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!bold[i]) {
                sb.append(s.charAt(i));
            } else {
                int j = i;
                while (j < s.length() && bold[j]) j++;
                sb.append("<b>" + s.substring(i, j) + "</b>");
                i = j - 1;
            }
        }
        return sb.toString();
    }

}
