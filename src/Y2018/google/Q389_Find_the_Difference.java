package Y2018.google;

public class Q389_Find_the_Difference {

    public char findTheDifference(String s, String t) {
        int[] f = new int[26];
        for (char c : s.toCharArray()) f[c - 'a']++;
        for (char c : t.toCharArray()) f[c - 'a']--;
        int i;
        for (i = 0; i < 26; i++) {
            if (f[i] != 0) break;
        }
        return (char) (i + 'a');
    }

}
