package archive.google;

public class Q345_Reverse_Vowels_of_a_String {

    public String reverseVowels(String s) {
        int l = 0, r = s.length()-1;
        char[] ss = s.toCharArray();
        while (l < r) {
            if (!isVowel(ss[l])) l++;
            else if (!isVowel(ss[r])) r--;
            else {
                ss[l] ^= ss[r];
                ss[r] ^= ss[l];
                ss[l] ^= ss[r];
                l++;
                r--;
            }
        }
        return String.valueOf(ss);
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}
