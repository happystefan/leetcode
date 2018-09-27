package oa.coursera;

import java.util.*;

public class Segment {

    public static int segment(int x, List<Integer> arr) {
        // Write your code here
        ArrayDeque<Integer> Q = new ArrayDeque<>();
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            while (!Q.isEmpty() && Q.peek() < i-x+1) {
                Q.poll();
            }
            while (!Q.isEmpty() && arr.get(Q.peekLast()) > arr.get(i)) {
                Q.pollLast();
            }
            Q.offer(i);
            if (i >= x - 1) {
                result = Math.max(result, arr.get(Q.peek()));
            }
        }
        return result;
    }

}
