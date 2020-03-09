package Y2020.facebook;

import java.util.LinkedList;
import java.util.List;

public class Q0271_Encode_and_Decode_Strings {

    public class Codec {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();
            for (String str : strs) {
                sb.append(str.length());
                sb.append(" ");
                sb.append(str);
            }
            return sb.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> rslt = new LinkedList<>();
            int i = 0;
            while (i < s.length()) {
                int j = s.indexOf(" ", i);
                int len = Integer.valueOf(s.substring(i, j));
                rslt.add(s.substring(j + 1, j + len + 1));
                i = j + len + 1;
            }
            return rslt;
        }

    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.decode(codec.encode(strs));
}
