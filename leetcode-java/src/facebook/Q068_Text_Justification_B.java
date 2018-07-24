package facebook;

import java.util.*;

public class Q068_Text_Justification_B {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            int l = i, r = i;
            int width = -1;
            while (r < words.length && width+words[r].length()+1 <= maxWidth) {
                width += words[r].length()+1;
                r++;
            }
            r--;
            width = width-(r-l);
            int space = r == l ? 0 : (maxWidth-width)/(r-l);
            int extra = r == l ? maxWidth-width : (maxWidth-width)%(r-l);
            StringBuilder sb = new StringBuilder(words[l]);
            if (r == words.length-1) {
                for (int j = l+1; j <= r; j++) {
                    addSpace(sb, 1);
                    sb.append(words[j]);
                }
            } else {
                for (int j = l+1; j <= r; j++) {
                    addSpace(sb, space);
                    if (extra > 0) {
                        addSpace(sb, 1);
                        extra--;
                    }
                    sb.append(words[j]);
                }
            }
            addSpace(sb, maxWidth-sb.length());
            result.add(sb.toString());
            i = r;
        }
        return result;
    }

    private void addSpace(StringBuilder sb, int num) {
        while (num-- > 0) {
            sb.append(" ");
        }
    }

}
