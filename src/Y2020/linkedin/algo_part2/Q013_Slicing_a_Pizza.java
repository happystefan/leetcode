package Y2020.linkedin.algo_part2;

import java.util.LinkedList;
import java.util.List;

public class Q013_Slicing_a_Pizza {

    /*
    * f(0) = 1
    * f(1) = 2
    * f(2) = 4
    * f(3) = 7
    * ...
    * f(n+1) = f(n) + n + 1
    *
    * f(n) = 2 + 2 + 3 + ... n = (1 + 2 + 3 + .. + n) + 1 = n * (n + 1) / 2 + 1;
    *
    * intuition: when add a new line, make it intersect with all other lines
    * */
    public int numOfSlice(int n) {
        return n * (n + 1) / 2 + 1;
    }

    class Line {
        double slope;
        double intercept;
        public Line(double slope, double intercept) {
            this.slope = slope;
            this.intercept = intercept;
        }
    }

    // different slope AND different intercept
    //  - same slope --> parallel lines
    //  - same intercept --> multiple line intercept at same point
    public List<Line> nLines(int n) {
        List<Line> rslt = new LinkedList<>();
        double slope = 0, intercept = 0;
        for (int i = 0; i < n; i++) {
            rslt.add(new Line(slope, intercept));
            slope += 1;
            intercept += 1;
        }
        return rslt;
    }
}
