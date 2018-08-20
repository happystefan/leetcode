package archive.google;

public class Q389_Find_the_Difference_B {

    public char findTheDifference(String s, String t) {
        char ans = 0;
        for (char c : s.toCharArray()) ans ^= c;
        for (char c : t.toCharArray()) ans ^= c;
        return ans;
    }

}
