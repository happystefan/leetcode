package Y2018.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q535_Encode_and_Decode_TinyURL {

    public class Codec {

        Map<String, Integer> mapl = new HashMap<>();
        Map<Integer, String> maps = new HashMap<>();
        String prefix = "http://tinyurl.com/";

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            mapl.put(longUrl, mapl.size());
            maps.put(mapl.get(longUrl), longUrl);
            return prefix + mapl.get(longUrl);
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            int idx = Integer.valueOf(shortUrl.replaceAll(prefix, ""));
            return maps.get(idx);
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));

}
