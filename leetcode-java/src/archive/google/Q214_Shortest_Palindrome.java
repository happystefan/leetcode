package archive.google;

public class Q214_Shortest_Palindrome {

    public String shortestPalindrome(String s) {
        String r = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < s.length(); i++) {
            if (s.startsWith(r.substring(i))) {
                return r.substring(0, i)+s;
            }
        }
        return r+s;
    }
    
}
