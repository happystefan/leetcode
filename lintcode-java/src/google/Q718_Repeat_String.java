package google;

/**
 * Created by mingqiangliang on 12/25/17.
 */
public class Q718_Repeat_String {

    public int repeatedString(String A, String B) {
        // write your code here
        if (A.equals("")) return B.equals("") ? 1 : -1;
        if (B.equals("")) return A.equals("") ? 1 : -1;

        String str = "";
        int ans = 0;
        while (str.length() < B.length()) {
            str += A;
            ans++;
        }
        if (str.contains(B)) return ans;
        str += A;
        return str.contains(B) ? ans+1 : -1;
    }

}
