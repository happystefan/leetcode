package archive.google;

public class Q657_Judge_Route_Circle {

    public boolean judgeCircle(String moves) {
        int u = 0, d = 0, l = 0, r = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U') u++;
            if (c == 'D') d++;
            if (c == 'L') l++;
            if (c == 'R') r++;
        }
        return u == d && l == r;
    }

}
