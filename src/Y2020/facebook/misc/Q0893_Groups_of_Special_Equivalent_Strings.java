package Y2020.facebook.misc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q0893_Groups_of_Special_Equivalent_Strings {

    class solution_sort {

        public int numSpecialEquivGroups(String[] A) {
            Set<String> groups = new HashSet<>();
            for (String str : A) groups.add(keyFunc(str));
            return groups.size();
        }

        private String keyFunc(String str) {
            StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (i % 2 == 1) sb1.append(str.charAt(i));
                else sb2.append(str.charAt(i));
            }
            char[] ss1 = sb1.toString().toCharArray();
            char[] ss2 = sb2.toString().toCharArray();
            Arrays.sort(ss1);
            Arrays.sort(ss2);
            return new String(ss1) + new String(ss2);
        }

    }

    class solution_count {

        public int numSpecialEquivGroups(String[] A) {
            Set<String> groups = new HashSet<>();
            for (String str : A) groups.add(keyFunc(str));
            return groups.size();
        }

        private String keyFunc(String str) {
            int[] cnt = new int[52];
            char[] ss = str.toCharArray();
            for (int i = 0; i < ss.length; i++) {
                cnt[ss[i] - 'a' + 26 * (i % 2)]++;
            }
            return Arrays.toString(cnt);
        }

    }

}
