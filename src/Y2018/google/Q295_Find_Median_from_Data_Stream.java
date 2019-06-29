package Y2018.google;

import java.util.PriorityQueue;

public class Q295_Find_Median_from_Data_Stream {

    class MedianFinder {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {

        }

        public void addNum(int num) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
            else return (maxHeap.peek() + minHeap.peek()) * 0.5;
        }

    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

}
