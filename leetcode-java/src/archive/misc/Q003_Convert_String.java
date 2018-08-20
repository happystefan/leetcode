package archive.misc;

public class Q003_Convert_String {

    /**
     * Write a function that, given a string S and a string T, return 1 if it's possible to convert
     * string S into string T by deleting some(possible zero) characters from string S, and otherwise
     * returns 0
     *
     *
     * For example, given S="abcd" and T="abd" the function should return 1. We can delete 'c' from
     * string S to convert string S into string T. However, given S="ab" and T="ba" the function should
     * return 0.
     *
     * Assume that:
     * * the length of ('S' , 'T') is within the range [1..1,000]
     * * strings S and T consist only of lower-case letters (a-z).
     *
     */

    public boolean convertString(String s, String t) {
        return isSubSequence(t, s);
    }

    private boolean isSubSequence(String t, String s) {
        int j = 0;
        for (int i = 0; i < s.length() && j < t.length(); i++) {
            if (t.charAt(j) == s.charAt(i)) {
                j++;
            }
        }
        return j == t.length();
    }

}
