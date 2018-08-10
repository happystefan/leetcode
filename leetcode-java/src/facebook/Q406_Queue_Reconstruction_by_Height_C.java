package facebook;

import java.util.*;

public class Q406_Queue_Reconstruction_by_Height_C {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        // bit is the underlying array for a binary search tree
        int[] bit = new int[people.length+1];
        for (int i = 1; i <= people.length; i++) {
            // 1 means the slot is empty
            update(bit, i, 1);
        }
        int[][] result = new int[people.length][2];
        for (int[] person : people) {
            int pos = getKth(bit, person[1] + 1);
            result[pos-1] = person;
            update(bit, pos, -1);
        }
        return result;
    }

    private void update(int[] bit, int pos, int delta) {
        for (int i = pos; i < bit.length; i += (i & -i)) {
            bit[i] += delta;
        }
    }

    // number of empty slot between [1, pos]
    private int getSum(int[] bit, int pos) {
        int sum = 0;
        for (int i = pos; i > 0; i -= (i & -i)) {
            sum += bit[i];
        }
        return sum;
    }

    // get Kth 1 in this bit array
    private int getKth(int[] bit, int k) {
        int lo = 1, hi = bit.length-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (getSum(bit, mid) < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

}
