package binary_search;

public class Q744_Find_Smallest_Letter_Greater_Than_Target {

    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length-1;
        while (l <= r) {
            int m = l + (r-l)/2;
            if (letters[m] <= target) {
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return letters[l%letters.length];
    }

}
