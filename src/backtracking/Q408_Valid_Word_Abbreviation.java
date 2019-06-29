package backtracking;

public class Q408_Valid_Word_Abbreviation {

    public boolean validWordAbbreviation(String word, String abbr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < abbr.length(); ) {
            if (Character.isLetter(abbr.charAt(i))) {
                sb.append(abbr.charAt(i));
                i++;
            } else if (abbr.charAt(i) != '0') {
                int j = i;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    j++;
                }
                int cnt = Integer.valueOf(abbr.substring(i, j));
                if (sb.length() + cnt > word.length()) {
                    return false;
                }
                while (cnt-- > 0) {
                    sb.append('#');
                }
                i = j;
            } else {
                return false;
            }
        }
        String str = sb.toString();
        if (str.length() != word.length()) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != str.charAt(i) && str.charAt(i) != '#') {
                return false;
            }
        }
        return true;
    }

}
