package Y2018.google;

public class Q374_Guess_Number_Higher_or_Lower {

    class GuessGame {
        int guess(int num) {
            return -1;
        }
    }

    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int l = 0, r = n;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (guess(m) == 1) l = m;
                else if (guess(m) == -1) r = m;
                else return m;
            }
            return l;
        }
    }

}
