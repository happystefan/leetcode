package random_pick;

import java.util.Random;

public class Q478_Generate_Random_Point_in_a_Circle {

    class Solution {

        Random random = new Random();
        double radius;
        double x_center;
        double y_center;

        public Solution(double radius, double x_center, double y_center) {
            this.radius = radius;
            this.x_center = x_center;
            this.y_center = y_center;
        }

        public double[] randPoint() {
            double r = radius * Math.sqrt(random.nextDouble());
            double d = random.nextDouble() * 2 * Math.PI;
            return new double[]{x_center + Math.cos(d) * r, y_center + Math.sin(d) * r};
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */

}
