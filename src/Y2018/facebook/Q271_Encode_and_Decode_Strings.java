package Y2018.facebook;

import java.util.LinkedList;
import java.util.List;

public class Q271_Encode_and_Decode_Strings {

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
            List<String> result = new LinkedList<>();
            int i = 0;
            while (i < s.length()) {
                int idx = s.indexOf(" ", i);
                int len = Integer.valueOf(s.substring(i, idx));
                result.add(s.substring(idx + 1, idx + len + 1));
                i = idx + len + 1;
            }
            return result;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));

}
