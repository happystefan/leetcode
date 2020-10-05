package Y2020.linkedin.algo_part1;

public class Q010_String_Replacement {

    class solution_iterative {

        public String replace(String str, String pattern, String target) {
            if (str == null || str.length() == 0) return str;
            if (!str.contains(pattern)) return str;
            if (pattern.equals(target)) return str;
            StringBuilder sb = new StringBuilder();
            int prev = 0;
            while (prev < str.length()) {
                int next = str.indexOf(pattern, prev);
                if (next == -1) break;
                sb.append(str.substring(prev, next));
                sb.append(target);
                prev = prev + pattern.length();
            }
            sb.append(str.substring(prev));
            return sb.toString();
        }

    }

    class solution_recursive {
        public String replace(String str, String pattern, String target) {
            if (str == null || str.length() == 0) return str;
            if (!str.contains(pattern)) return str;
            if (pattern.equals(target)) return str;

            int idx = str.indexOf(pattern);
            if (idx == -1) return str;
            return str.substring(0, idx) + target + replace(str.substring(idx + pattern.length()), pattern, target);
        }

    }

}
