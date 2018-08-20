package archive.google;

import java.util.LinkedList;

public class Q346_Moving_Average_from_Data_Stream {

    class MovingAverage {

        double sum;
        int size;
        LinkedList<Integer> list = new LinkedList<>();

        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            this.sum = 0;
            this.size = size;
        }

        public double next(int val) {
            list.add(val);
            sum += val;
            if (list.size() > size) {
                sum -= list.getFirst();
                list.removeFirst();
            }
            return sum/list.size();
        }

    }

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

}
