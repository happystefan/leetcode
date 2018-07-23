package facebook;

import java.util.*;

public class Q068_Text_Justification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            int l = i, r = i, width = 0;
            while (r < words.length && width <= maxWidth) {
                if (r != l) width += 1;
                width += words[r].length();
                r++;
            }
            r--;
            if (width > maxWidth) {
                width -= words[r].length();
                if (r > l) width -= 1;
                r--;
            }

            int wordNum = r-l+1;
            int spaceNum = wordNum == 1 ? 0 : (maxWidth-width+(wordNum-1))/(wordNum-1);
            int extraSpace = wordNum == 1 ? maxWidth-width : (maxWidth-width+(wordNum-1))%(wordNum-1);

            System.out.printf("%d %d\n", spaceNum, extraSpace);
            StringBuilder sb = new StringBuilder();
            if (r == words.length-1) { // last line
                for (int j = l; j <= r; j++) {
                    if (j != l) sb.append(" ");
                    sb.append(words[j]);
                }
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else {
                for (int j = l; j <= r; j++) {
                    //if (j != l) sb.append(" ");
                    if (j != l) {
                        for (int k = 0; k < spaceNum; k++) {
                            sb.append(" ");
                        }
                    }
                    sb.append(words[j]);
                    if (j == l) {
                        for (int k = 0; k < extraSpace; k++) {
                            sb.append(" ");
                        }
                    }
                }
            }
            //System.out.println(sb.toString());
            result.add(sb.toString());
            i = r;
        }
        return result;
    }

}
