package archive.facebook;

import java.util.*;

public class Q346_Moving_Average_from_Data_Stream {

    class MovingAverage {

        double sum = 0;
        int size = 0;
        ArrayDeque<Integer> Q = new ArrayDeque();
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            this.size = size;
        }

        public double next(int val) {
            if (Q.size() == size) {
                sum -= Q.pollFirst();
            }
            Q.addLast(val);
            sum += val;
            return sum/Q.size();
        }
    }

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

}
