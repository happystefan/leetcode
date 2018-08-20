package archive.dp;

public class Q647_Palindromic_Substrings_B {

    public int countSubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i;
            result++;
            while (l-1 >= 0 && r+1 < s.length()) {
                if (s.charAt(l-1) == s.charAt(r+1)) {
                    result++;
                    l--;
                    r++;
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i+1 < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i+1)) {
                continue;
            }
            result++;
            int l = i, r = i+1;
            while (l-1 >= 0 && r+1 < s.length()) {
                if (s.charAt(l-1) == s.charAt(r+1)) {
                    result++;
                    l--;
                    r++;
                } else {
                    break;
                }
            }
        }

        return result;
    }
}
