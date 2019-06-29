package Y2018.facebook;

import java.util.PriorityQueue;

public class Q295_Find_Median_from_Data_Stream {

    class MedianFinder {

        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b) -> b - a);

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
        }

        public void addNum(int num) {
            maxQ.add(num);
            minQ.add(maxQ.poll());
            if (minQ.size() > maxQ.size()) {
                maxQ.add(minQ.poll());
            }
        }

        public double findMedian() {
            return maxQ.size() == minQ.size() ? (maxQ.peek() + minQ.peek()) * 0.5 : maxQ.peek();
        }

    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

}
