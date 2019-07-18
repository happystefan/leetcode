package Y2019.Q0001_Q0300;

import java.util.LinkedList;
import java.util.List;

public class Q0068_Text_Justification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new LinkedList<>();
        int i = 0;
        while (i < words.length) {
            int j = i;
            int len = words[i].length();
            while (j + 1 < words.length && len + words[j + 1].length() + 1 <= maxWidth) {
                len += words[j + 1].length() + 1;
                j++;
            }

            StringBuilder sb = new StringBuilder();
            if (j - i == 0 || j == words.length - 1) {
                for (int k = i; k <= j; k++) {
                    if (k != i) sb.append(" ");
                    sb.append(words[k]);
                }
                while (sb.length() != maxWidth) sb.append(" ");
            } else {
                int totalSpace = maxWidth - len + (j - i);
                int avgSpace = totalSpace / (j - i);
                int extraSpace = totalSpace % (j - i);
                for (int k = i; k <= j; k++) {
                    if (k != i) {
                        for (int kk = 0; kk < avgSpace; kk++) sb.append(" ");
                        if (extraSpace > 0) {
                            sb.append(" ");
                            extraSpace--;
                        }
                    }
                    sb.append(words[k]);
                }
            }
            result.add(sb.toString());
            i = j + 1;
        }
        return result;
    }

}
