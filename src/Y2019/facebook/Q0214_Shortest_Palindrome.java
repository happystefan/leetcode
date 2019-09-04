package Y2019.facebook;

public class Q0214_Shortest_Palindrome {

    public String shortestPalindrome(String s) {
        String r = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < r.length(); i++) {
            if (s.startsWith(r.substring(i))) {
                return r.substring(0, i) + s;
            }
        }
        return r + s;
    }

}
