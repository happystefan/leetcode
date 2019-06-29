package Y2018.facebook;

import java.util.LinkedList;
import java.util.List;

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
                r--;
            }

            width = 0;
            for (int j = l; j <= r; j++) {
                width += words[j].length();
            }
            int wordNum = r - l + 1;
            int spaceNum = wordNum == 1 ? 0 : (maxWidth - width) / (wordNum - 1);
            int extraSpace = wordNum == 1 ? maxWidth - width : (maxWidth - width) % (wordNum - 1);

            StringBuilder sb = new StringBuilder();
            if (r == words.length - 1) { // last line
                for (int j = l; j <= r; j++) {
                    if (j != l) sb.append(" ");
                    sb.append(words[j]);
                }
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else {
                for (int j = l; j <= r; j++) {
                    if (j != l) {
                        for (int k = 0; k < spaceNum; k++) {
                            sb.append(" ");
                        }
                    }
                    sb.append(words[j]);
                    if (l == r) {
                        while (extraSpace-- > 0) {
                            sb.append(" ");
                        }
                    } else {
                        if (extraSpace > 0) {
                            sb.append(" ");
                            extraSpace--;
                        }
                    }
                }
            }
            result.add(sb.toString());
            i = r;
        }
        return result;
    }

}
