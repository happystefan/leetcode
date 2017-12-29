package google;

import java.util.LinkedList;
import java.util.List;

public class Q535_Encode_and_Decode_TinyURL {

    public class Codec {

        List<String> list = new LinkedList<>();
        String host = "http://tinyurl.com/";

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            list.add(longUrl);
            return host+String.valueOf(list.size()-1);
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return list.get(Integer.valueOf(shortUrl.replace(host, "")));
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));

}
