package google;

/**
 * Created by mingqiangliang on 12/23/17.
 */
public class Q662_Guess_Number_Game {

    public class GuessGame {
        public int guess(int n) {
            return 1;
        }
    }

    public class Solution extends GuessGame {
        /**
         * @param n an integer
         * @return the number you guess
         */
        public int guessNumber(int n) {
            // Write your code here
            int l = 1, r = n;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                int res = guess(mid);
                if (res == -1) r = mid - 1;
                else if (res == 1) l = mid + 1;
                else return mid;
            }
            return -1;
        }

    }

}
