package vmware.serialize_deserialize;

import java.util.*;

public class Q271_Encode_and_Decode_Strings {

    public class Codec {
        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            if (strs == null) return "null";
            StringBuilder sb = new StringBuilder();
            for (String str : strs) {
                sb.append(str == null ? -1 : str.length());
                sb.append("#");
                sb.append(str == null ? "" : str);
            }
            return sb.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            if (s.equals("null")) return null;
            List<String> result = new LinkedList<>();
            int pos = 0;
            while (pos != s.length()) {
                int idx = s.indexOf("#", pos);
                int len = Integer.valueOf(s.substring(pos, idx));
                if (len == -1) {
                    result.add(null);
                    pos = idx + 1;
                } else {
                    result.add(s.substring(idx + 1, idx + 1 + len));
                    pos = idx + 1 + len;
                }
            }
            return result;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));

}

