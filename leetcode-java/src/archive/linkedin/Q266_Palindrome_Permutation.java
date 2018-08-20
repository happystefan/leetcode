package archive.linkedin;

public class Q266_Palindrome_Permutation {

    public boolean canPermutePalindrome(String s) {
        int[] f = new int[256];
        for (char c : s.toCharArray()) {
            f[c]++;
        }
        int cnt = 0;
        for (int i = 0; i < f.length; i++) {
            if (f[i]%2 == 1) {
                cnt++;
            }
            if (cnt > 1) {
                return false;
            }
        }
        return true;
    }

}
