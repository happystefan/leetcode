package misc;

import java.util.*;

public class Q010_K_Empty_Slots {

    class K_Empty_Slots {
        /*
        ----------------------------------------------------------------------------------------------------------------
        There is a garden with N slots. In each slot, there is a flower. The N flowers will bloom one by one in N days.
        In each day, there will be exactly one flower blooming and it will be in the status of blooming since then.

        Given an array flowers consists of number from 1 to N. Each number in the array represents the place where the
        flower will open in that day.

        For example, flowers[i] = x means that the unique flower that blooms at day i will be at position x, where i and x
        will be in the range from 1 to N.

        Also given an integer k, you need to output in which day there exists two flowers in the status of blooming, and
        also the number of flowers between them is k and these flowers are not blooming.

        If there isn't such day, output -1.
        ----------------------------------------------------------------------------------------------------------------
        */

        // TreeSet: O(N*log(N))
        public int kEmptySlots(int[] flowers, int k) {
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < flowers.length; i++) {
                Integer higher = set.higher(flowers[i]);
                Integer lower = set.lower(flowers[i]);
                if (higher != null && higher - flowers[i] - 1 == k || lower != null && flowers[i] - lower - 1 == k)  {
                    return i + 1;
                }
                set.add(flowers[i]);
            }
            return -1;
        }

        // SlidingWindows: O(N)
        public int kEmptySlots_II(int[] flowers, int k) {
            int[] days = new int[flowers.length];
            for (int i = 0; i < flowers.length; i++) {
                days[flowers[i]-1] = i+1;
            }
            int l = 0, r = k+1;
            int result = Integer.MAX_VALUE;
            for (int i = 1; r < flowers.length; i++) {
                // current days[i] is valid, continue scanning
                if (days[i] > days[l] && days[i] > days[r]) {
                    continue;
                }
                // reach boundary of sliding window, since previous number are all valid, record result
                if (i == r) {
                    result = Math.min(result, Math.max(days[l], days[r]));
                }
                // not valid, move the sliding window
                l = i;
                r = i+k+1;
            }
            return result == Integer.MAX_VALUE ? -1 : result;
        }

    }

    class K_Empty_Slots_B {
        /*
        ----------------------------------------------------------------------------------------------------------------
        b. k个empty slot 存在的最晚一天（被破坏的那一天）
        ----------------------------------------------------------------------------------------------------------------
        */
        public int kEmptySlots(int[] flowers, int k) {
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = flowers.length-1; i >= 0; i--) {
                Integer higher = set.higher(flowers[i]);
                Integer lower = set.lower(flowers[i]);
                if (higher != null && higher - flowers[i] - 1 == k || lower != null && flowers[i] - lower - 1 == k)  {
                    return i + 1;
                }
                set.add(flowers[i]);
            }
            return -1;
        }

        public int kEmptySlots_II(int[] flowers, int k) {
            int[] days = new int[flowers.length];
            for (int i = 0; i < flowers.length; i++) {
                days[flowers[i]-1] = i+1;
            }
            int l = 0, r = k+1;
            int result = Integer.MIN_VALUE;
            for (int i = 1; r < flowers.length; i++) {
                // current days[i] is valid, continue scanning
                if (days[i] > days[l] && days[i] > days[r]) {
                    continue;
                }
                // reach boundary of sliding window, since previous number are all valid, record result
                if (i == r) {
                    result = Math.max(result, Math.max(days[l], days[r]));
                }
                // invalid, move the sliding window
                l = i;
                r = i+k+1;
            }
            return result == Integer.MIN_VALUE ? -1 : result;
        }

    }

    class K_Empty_Slots_C {
        /*
        ----------------------------------------------------------------------------------------------------------------
        c. 连续k个花（有且仅有k个花连着）出现的最早的一天
        ----------------------------------------------------------------------------------------------------------------
        */
        public int kEmptySlots(int[] flowers, int k) {
            return 0;
        }

    }


    /*

    d. 连续k个花（有且仅有k个花连着）出现的最晚的一天（被破坏的那一天）

    e. 多一个参数M， 至少k个花挨着，M组k花花团出现的最早一天

    f. 多一个参数M， 至少k个花挨着，M组k花花团留存的最晚一天（被破坏的那一天）

    g. 多一个参数M， 正好k个花挨着的花团（有且只能有k个花连着），M组k花花团留存的最晚一天（被破坏的那一天）
    */
}
