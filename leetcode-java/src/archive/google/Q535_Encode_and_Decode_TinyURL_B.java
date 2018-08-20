package archive.google;

import java.util.HashMap;
import java.util.Map;

public class Q535_Encode_and_Decode_TinyURL_B {

    public class Codec {

        Map<Integer, String> map = new HashMap<>();
        String host = "http://tinyurl.com/";

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            int key = longUrl.hashCode();
            map.put(key, longUrl);
            return host+key;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return map.get(Integer.valueOf(shortUrl.replace(host, "")));
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));

}
