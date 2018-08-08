package misc;

import java.util.*;

public class Q015_Custom_Sort {

    // 遇到数字时就比大小，其它任何时候都正常地比字符
    // 比如[ ab12ab, ab12a2b,  a121b12, a12 ] 这种情况的话，应该是 a12, a121b12, ab12a2b, ab12ab
    public void customSort(String[] A) {
        Arrays.sort(A, (a, b) -> {
            if (a.equals(b)) {
                return 0;
            }
            if (a.contains(b)) {
                return 1;
            }
            if (b.contains(a)) {
                return -1;
            }
            for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
                if (Character.isLetter(a.charAt(i)) || Character.isLetter(b.charAt(i))) {
                    if (a.charAt(i) == b.charAt(i)) {
                        continue;
                    } else {
                        return a.charAt(i)-b.charAt(i);
                    }
                }

                int ja = i;
                while (ja < a.length() && Character.isDigit(a.charAt(ja))) {
                    ja++;
                }
                int jb = i;
                while (jb < b.length() && Character.isDigit(b.charAt(jb))) {
                    jb++;
                }

                int numa = Integer.valueOf(a.substring(i, ja)), numb = Integer.valueOf(b.substring(i, jb));
                if (numa == numb) {
                    i = ja;
                    continue;
                } else {
                    return numa-numb;
                }
            }
            return a.length()-b.length();
        });
    }

}
