package google;

public class Q657_Judge_Route_Circle_B {

    public boolean judgeCircle(String moves) {
        int h = 0, v = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U') v++;
            if (c == 'D') v--;
            if (c == 'L') h++;
            if (c == 'R') h--;
        }
        return h == 0 && v == 0;
    }

}
